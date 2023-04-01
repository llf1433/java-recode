import java.util.Arrays;

public class HashBucket {

    private static class Node {
        /*
            key-value 模型
        */
        private int key; //
        private int value; //
        Node next; //


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private Node[]  array;//
    private int size;   // 当前的数据个数
    private static final double LOAD_FACTOR = 0.75; //负载因子
    private static final int DEFAULT_SIZE = 8;//默认桶的大小

    public void put(int key, int value) {
        int index = key % array.length;//存放的地址
        Node cur = array[index];
        /*
            已经存在key时跟更新value
         */
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return; //正常结束
            }
            cur = cur.next;
        }

        /*
            头插法
         */
        Node newNode = new Node(key, value);
        newNode.next = array[index];
        array[index] = newNode;
        this.size++;

        if (loadFactor() >= LOAD_FACTOR) {
            //扩容 -- 对每个元素重新哈希
            resize();
        }

    }





    private void resize() {
        //array = Arrays.copyOf(array,array.length * 2);
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                Node curNext = cur.next;//
                int newIndex =  cur.key % newArray.length;
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }


    private double loadFactor() {
        return size * 1.0 / array.length;
    }


    public HashBucket() {
        array = new Node[DEFAULT_SIZE];//默认大小
    }


    public int get(int key) {
        int index = key % array.length;//存放的地址
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }

        return -1;
    }

    public static void main(String[] args) {
        HashBucket hashBucket = new HashBucket();
        hashBucket.put(8,1);
        hashBucket.put(16,2);
        hashBucket.put(2,2);
        hashBucket.put(4,2);
        hashBucket.put(14,2);
        hashBucket.put(34,2);
        hashBucket.put(17,2);
        hashBucket.put(11,2);
        hashBucket.put(8,2);

        System.out.println(hashBucket.get(8));

    }
}

import java.util.Arrays;

public class PriorityQueue {
    public int[] elem;  //数组存放堆
    public int usedSize; //使用空间的大小

    public PriorityQueue() {

    }

    /**
     * 向下调整建堆 建堆的时间复杂度：O(N)
     * 向上调整建堆 建堆的时间复杂度：O(NlogN)
     * @param array
     */

    //向下调整建堆 时间复杂度：O(N)
    public void createHeap(int[] array) {
        this.elem = array;
        this.usedSize = array.length;
        /*int child = array.length - 1;//最后一个结点下标
        int parent = (i - 1) / 2;// 左/右孩子 父节点都是此表达式 -- 保证从0下标开始除法会向下取整*/
        for (int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(parent, usedSize);
        }
    }

    //向上调整建堆 时间复杂度O(NlogN)
    public void createHeap2(int[] array) {
        this.elem = array;
        this.usedSize = array.length;;
        for(int child = 0; child < usedSize; child++) {
            shiftUp(child);
        }
    }

    /**
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     *             向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root, int len) {
        int child = 2 * root + 1;
        //完全二树必须有左孩子
        while (child < len) {
            /*
             *  child + 1 不能越界
             *  '<' 建小堆  '>' 建大堆  -- 父结点与孩子比较 ‘<’ 则交换
             */
            if (child + 1 < len && elem[child] > elem[child + 1]) {
                child++;
            }

            //判断--交换
            if (elem[child] < elem[root]) {
                int tmp = elem[child];
                elem[child] = elem[root];
                elem[root] = tmp;
                //继续调整
                root = child;
                child = root * 2 + 1;
            } else {
                break; //
            }
        }
    }

    /*
     * 入队：仍然要保持是大根堆
     * @param val
     **/
    public void push(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, elem.length << 2);
        }

        //向上调整 push -- 调整一次
        elem[usedSize] = val;
        shiftUp(usedSize);
        usedSize++;

        //向下调整 push 时间复杂度比向上调整高 -- 调整多次
        /*elem[usedSize] = val;
        for (int parent = (usedSize - 1) / 2; parent >= 0; parent--) {
            shiftDown(parent, usedSize + 1);
        }
        usedSize++;*/

    }

    private void shiftUp(int child) {
        while (child != 0) {
            int parent = (child - 1) / 2;
            // '<'建小堆
            if (elem[child] < elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
            } else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;//
    }


    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是 大根堆
     */
    public void pollHeap() {
        elem[0] = elem[usedSize - 1];//
        shiftDown(0,usedSize - 1);
        usedSize--;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }


    /**
     * 获取堆顶元素
     *
     */

    public int peekHeap() {
        if (!isEmpty()) {
            return elem[0];
        }
        return -1;
    }


    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        int[] array = {1, 2, 9, 10, 8, 7};
        priorityQueue.createHeap(array);
        for (int x: priorityQueue.elem) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("=======================");
        PriorityQueue priorityQueue2 = new PriorityQueue();
        int[] array2 = {1, 2, 9, 10, 8, 7};
        priorityQueue2.createHeap2(array2);
        for (int x: priorityQueue2.elem) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("=======================");
        priorityQueue2.push(0);
        for (int i = 0; i < priorityQueue2.usedSize; i++) {
            System.out.print(priorityQueue2.elem[i] + " ");
        }
        System.out.println();
        System.out.println("=======================");
        priorityQueue2.pollHeap();
        for (int i = 0; i < priorityQueue2.usedSize; i++) {
            System.out.print(priorityQueue2.elem[i] + " ");
        }
        System.out.println();
        System.out.println("=======================");
    }
}
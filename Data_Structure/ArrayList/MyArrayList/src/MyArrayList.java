
import java.util.Arrays;

public class MyArrayList {
    private int[] elem;//数组
    private int usedSize;//使用长度
    static final int DEFAULT_SIZE = 5;

    //无参构造
    public MyArrayList() {
        elem = new int[DEFAULT_SIZE];
        usedSize = 0;
    }


    public void display() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //添加元素
    public void add(int data) {
        //扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,elem.length * 2);
        }
        this.elem[usedSize++] = data;
    }

    //判断顺序表是否满了
    public boolean isFull() {
        return size() >= elem.length;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
       return -1;
    }

    //获取pos位置的元素
    public int get(int pos){
        if (pos < usedSize && pos >= 0) {
            return this.elem[pos];
        }
        return -1;
    }

    //顺序表长度
    public int size() {
        return this.usedSize;
    }

    //给pos位置更新为value
    public void set(int pos, int value) throws EmptyException, PosWrongfulException {
        if (this.isEmpty()) {
            throw new EmptyException("当前顺序表为空！");
        }
        if (pos < 0 || pos > this.size()) {
            throw new PosWrongfulException("set: pos位置不合法！");
        }
        this.elem[pos] = value;
    }

    //判断是否为空
    public boolean isEmpty() {
        return this.size() == 0;
    }

    //删除key
    public void remove(int key) throws EmptyException{
        if (this.isEmpty()) {
            throw new EmptyException("当前顺序表为空！");
        }
        int index = this.indexOf(key);
        if (index == -1) {
            System.out.println("没有找到这个关键字！");
            return;
        }
        for (int j = index; j <= this.size() - 1; j++) {
            this.elem[j] = this.elem[j + 1];
        }
       this.usedSize--;
    }

    public int removeElement(int val) {
        int ret = this.usedSize;
        for (int i = 0; i < ret; i++) {
            if (elem[i] == val) {
                for (int j = i; j <= ret - 1; j++) {
                    elem[j] = elem[j + 1];
                }
                i--;
                ret -= 1;
            }
        }
        return ret;
    }

    public int removeDuplicates() {
        int low = 0;
        int high = 1;
        while (high < elem.length) {
            if (elem[low] != high && high - low > 1) {
                elem[low + 1] = elem[high];
                low++;
            }
            high++;
        }
        return low+1;
    }
    

    //清除顺序表
    public void clear() {
        this.usedSize = 0;
    }
}

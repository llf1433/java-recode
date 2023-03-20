/**
 * 循环队列
 */
public class MyCircularQueue {
    private final int[] elem;
    private int rear;
    private int front;

    public MyCircularQueue(int k) {
        elem = new int[k + 1];//用一个无效位 用来检查和循环 使rear从最后到0
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }
        elem[rear] = value;
        rear = (rear + 1) % elem.length;//
        return true;


    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front =  (front + 1) % elem.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return elem[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int ret = rear == 0 ? elem.length - 1 : rear - 1;
        return elem[ret];

    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % elem.length == front;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(7);
        System.out.println(myCircularQueue.enQueue(100));
    }
}

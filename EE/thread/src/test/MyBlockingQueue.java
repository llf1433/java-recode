package test;

// 阻塞队列
// 考虑泛型,直接使用 int 代替元素类型
public class MyBlockingQueue {
    private int[] items = new int[1000]; //环形队列(循环队列)
    private int head = 0;//头指针下标
    private int tail = 0;//尾指针下标
    private int size = 0;// 有效数据的大小

    //入队列
    public synchronized void put(int value) throws InterruptedException {
        // 判断队列是否满
        while (size == items.length) {
            // 队列满了,产生阻塞
            this.wait();
            //return;
        }
        items[tail++] = value;
        // 对tail进行特殊处理
        // tail %= items.length;
        // 或者
        if (tail >= items.length) {
            tail = 0;
        }
        size++;
        //唤醒take()中的wait()
        this.notify();
    }

    //出队列
    public Integer take() throws InterruptedException {
        int result = 0;
        synchronized (this) {
            if (size == 0){
                //队列为空,产生阻塞
                this.wait();
                //return null;
            }
            result = items[head++];
            if (head >= items.length) {
                head = 0;
            }
            size--;
            // 唤醒put()中的wait()
            this.notify();
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
        myBlockingQueue.put(999);
        myBlockingQueue.put(123);




    }
}

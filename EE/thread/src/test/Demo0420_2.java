package test;

/**
 * 使用两个线程来累加 count 的值
 * 每个线程循环 1w 次，累加变量 count 的值，count 默认值为 0，注意线程安全问题。
 */
class Add{
    public int count = 0;
    public static int num = 10000;//累加次数
    /*
        加锁,保证线程安全
     */
    synchronized public void add() {
        for (int i = 0; i < num; i++) {
            count++;
        }
    }
}
public class Demo0420_2 {
    public static void main(String[] args) {
        Add a = new Add();
        Thread t1 = new Thread(()-> {
            a.add();
        });
        Thread t2 = new Thread(a::add);//Lambda表达式

        t1.start();
        t2.start();
        try {
            /*
                等待线程执行完成
             */
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(a.count);
    }
}

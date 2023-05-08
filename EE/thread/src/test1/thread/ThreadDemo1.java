package thread;

import static java.lang.Thread.sleep;

/**
 *  通过继承Thread类,来创建线程
 */
class Mythread extends Thread{
    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);// 睡眠 1s
            } catch (InterruptedException ignored) {

            }
            System.out.println("hello thread!");
        }
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        /*
            通过继承Thread,重写run()方法
            通过start()方法创建一个线程
            run()本身是线程执行的内容,new一个对象或者执行run()是不会创建线程的
            只有调用了start()方法才创建
            进程包含线程

         */
        Thread t = new Mythread();
        t.start();
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException ignored) {

            }
            System.out.println("hello main!");
        }
    }
}

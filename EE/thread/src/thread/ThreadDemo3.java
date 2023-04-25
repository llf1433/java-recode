package thread;

/**
 *  实现Runnable接口,调用Thread的构造方法
 *  实质上目的是为了解耦合,让线程和线程的任务分离开  --更加容易改动代码
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("This is thread!");
    }
}
public class ThreadDemo3 {
    public static void main(String[] args) {
        //这只是描述了要执行的任务
        Runnable runnable = new MyRunnable();
        //
        Thread t = new Thread(runnable);
        t.start();
        System.out.println("This is main!");

    }
}

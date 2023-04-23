package test;

public class Demo0423 {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println("A");
            synchronized (lock1) {
                lock1.notify();
            }

        });
        Thread t2 = new Thread(() -> {
            synchronized (lock1){
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            synchronized (lock2) {
                lock2.notify();
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (lock2)  {
                try {
                    lock2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
        });
        t2.start();
        t3.start();
        Thread.sleep(100);//让t2和t3先进入等待,不等待可能让t1的lock1.notify()执行了个寂寞
        t1.start();
    }
}

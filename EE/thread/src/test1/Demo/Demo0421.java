package test;
/**
 * t1和t2都对不同对象加锁,又互相再对对方的锁进行加锁,但必须等待对方加锁结束,形成"循环等待",从而形成死锁
 * 解决方法:破环"循环等待",让两个对象针对相同对象加锁(从而产生阻塞等待),
 */

import static java.lang.Thread.sleep;

public class Demo0421 {
    public static void main(String[] args) {
        Object soy = new Object();
        Object vinegar = new Object();
        Thread t1 = new Thread(()->{
            synchronized (soy) {
                /*
                    睡眠保证t1和t2都拿到第一把锁
                 */
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (vinegar){
                    System.out.println("我拿到了醋和酱油!");
                }
            }
        });
        Thread t2 = new Thread(()->{
           synchronized(vinegar) {
               try {
                   sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (soy) {
                   System.out.println("他拿到了醋和酱油!");
               }
           }
        });
        t1.start();
        t2.start();
    }
}

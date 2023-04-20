package thread;

import static java.lang.Thread.sleep;

public class Demo0419 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            //是否是中断标志 是中断则清除`中断标志
            while (!Thread.interrupted()){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("被中断(唤醒)了");
                    e.printStackTrace();
                    break;
                }
                System.out.println("正在工作...");
            }
        });
        thread.start();
        thread.sleep(5000);
        /*
            中断对象关联的线程，如果线程正在阻塞,则以异常方式通知,否则设置标志位
         */
        thread.interrupt();
    }

}

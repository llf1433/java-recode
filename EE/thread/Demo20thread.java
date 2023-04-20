package thread;



public class Demo20thread {
    public static void main(String[] args) throws InterruptedException {
        int num = 200;
        Thread[] threads = new Thread[num];//创建线程对象数组
        for (int i = 0; i < num; i++) {
            final int who = i;
            threads[i] = new Thread(()->{
                /*
                    只是描述了线程的任务
                 */
                System.out.println("thread" + who);
            });
            threads[i].start();//
        }
        for (Thread x : threads) {
            x.join();//等待此线程完成,如果未完成.主线程进入阻塞状态
        }
        System.out.println("ok");
    }
}

package test;

import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.PriorityBlockingQueue;

class OfficialTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时Task1");
            }
        },500);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时Task2");
            }
        },800);
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("运行定时Task3");
            }
        },1000);

    }
}


class MyTask implements Comparable<MyTask>{

    private Runnable runnable;// 任务的内容
    private long time;// time后执行Task ((毫秒)millisecond)
    public MyTask(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = time;
    }



    public void run(){
        runnable.run();
    }

    public long getTime(){
        return this.time;
    }

    @Override
    public int compareTo(MyTask o) {
        /*
            实现队首元素最小
         */
        return (int)(this.time - o.time);
    }
}
public class MyTimer {
    // 扫描线程
    Thread scanT;

    // 优先级阻塞队列
    PriorityBlockingQueue<MyTask> queue =
            new PriorityBlockingQueue<>();
    public MyTimer(){
        scanT = new Thread(()-> {
            while (true) {
                try {
                    synchronized(this) {
                        MyTask myTask = queue.take();
                        long currentTime = System.currentTimeMillis();
                       // 检查队首元素是否到时间了 如果时间未到,重新放回队列 -- take 和 put 线程安全 -- 此处put会"忙等"
                        if (currentTime < myTask.getTime()) {
                           // 时间未到不必执行
                            queue.put(myTask);
                            this.wait(myTask.getTime() - currentTime);
                        } else {
                           // 执行Task
                            myTask.run();
                        }
                   }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        scanT.start();
    }


    //
    public void schedule(Runnable runnable, long after){
        // runnable 描述Task的内容
        // after + 当前时间  传入时间戳
        MyTask myTask = new MyTask(runnable, System.currentTimeMillis()+ after);
        queue.put(myTask);//入队列
        synchronized (this) {
            this.notify();
        }
    }

}

class Test{
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(()->{
            System.out.println("Task1");
        },1000);
        timer.schedule(()->{
            System.out.println("Task2");
        },2000);

    }
}

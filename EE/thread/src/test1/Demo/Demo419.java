package test;

public class Demo419 {
    public static void main(String[] args) {
        concurrency();
    }
    public static void concurrency() {
        Thread thread1 = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
                a++;
            }
        });
        Thread thread2 = new Thread(() -> {
           long b = 0;
           for (long i = 0; i < 100_0000_0000L; i++) {
               b++;
           }
        });
        long begin = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("并发时间:" + (end - begin) + "ms");


    }
}

package test;

import java.util.Random;

/**
 * 编写代码, 实现多线程数组求和.
 * 给定一个很长的数组 (长度 1000w), 通过随机数的方式生成 1-100 之间的整数.
 * 实现代码, 能够创建两个线程, 对这个数组的所有元素求和.
 * 其中线程1 计算偶数下标元素的和, 线程2 计算奇数下标元素的和.
 * 最终再汇总两个和, 进行相加
 * 记录程序的执行时间.
 */

class Sum {
    public int Even;//偶下标和
    public int Odd;//奇
    public int ret;//和
    public void sumEven(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            Even += array[i];
        }
    }
    public void sumOdd(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            Odd += array[i];
        }
    }

    public void sumAll(int[] array) {
        for (int x:array) {
            ret += x;
        }
    }
}


public class Demo0420 {
    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[1000_0000];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }


        int sum = 0;
        Sum sum1 = new Sum();
        sum1.sumAll(array);

        /*
            t1线程求偶下标之和
            t2     奇
         */
        Thread t1 = new Thread(() -> {
            sum1.sumEven(array);
        });
        Thread t2 = new Thread(() -> {
            sum1.sumOdd(array);
        });
        // 记录开始时间
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            /*
                主线程阻塞
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int ret = sum1.Even + sum1.Odd;
        System.out.println("多线程:" + ret);
        System.out.println("单线程:" + sum1.ret);


    }

}

import java.util.Arrays;
import java.util.Random;

public class TestSort {
    public static void main(String[] args) {
        /*
          10万个随机数
         */
        int n = 10_0000;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n*2);
        }

        long begin = 0;
        long end = 0;

        begin = System.currentTimeMillis();
        InsertSort.sort(array);//插入排序
        end = System.currentTimeMillis();
        System.out.println("插入排序：" + (end - begin));

        System.out.println("==============");

        begin = System.currentTimeMillis();
        SelectSort.sort(array); //选择排序
        end = System.currentTimeMillis();
        System.out.println("选择排序：" + (end - begin));

        System.out.println("==============");

        begin = System.currentTimeMillis();
        HeapSort.sort(array); //堆排序
        end = System.currentTimeMillis();
        System.out.println("堆排序：" + (end - begin));

        System.out.println("==============");

        begin = System.currentTimeMillis();
        ShellSort.shellSort(array); //希尔排序
        end = System.currentTimeMillis();
        System.out.println("希尔排序：" + (end - begin));

        System.out.println("==============");

        begin = System.currentTimeMillis();
        BubbleSort.bubbleSort(array);//冒泡排序
        end = System.currentTimeMillis();
        System.out.println("冒泡排序：" + (end - begin));

        System.out.println("==============");

        /*begin = System.currentTimeMillis();
        QuickSort.quickSort(array);//快速排序 -- StackOverflow
        end = System.currentTimeMillis();
        System.out.println("快速排序：" + (end - begin));*/

        System.out.println("==============");


    }

}

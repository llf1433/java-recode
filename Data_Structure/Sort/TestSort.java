import java.util.Arrays;
import java.util.Random;

public class TestSort {

    public void testBubbleSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long begin = System.currentTimeMillis();
        BubbleSort.sort(array);//冒泡排序
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序：" + (end - begin));
    }

    public void testHeapSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long begin = System.currentTimeMillis();
        HeapSort.sort(array);//堆排序
        long end = System.currentTimeMillis();
        System.out.println("堆排序：" + (end - begin));
    }

    public void testInsertSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long begin = System.currentTimeMillis();
        InsertSort.sort(array);//插入排序
        long end = System.currentTimeMillis();
        System.out.println("插入排序：" + (end - begin));
    }

    public void testQuickSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long begin = System.currentTimeMillis();
        QuickSort.sort(array);//快速排序
        long end = System.currentTimeMillis();
        System.out.println("快速排序：" + (end - begin));
    }

    public void testSelectSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long begin = System.currentTimeMillis();
        SelectSort.sort(array);//选择排序
        long end = System.currentTimeMillis();
        System.out.println("选择排序：" + (end - begin));
    }

    public void testShellSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long begin = System.currentTimeMillis();
        ShellSort.sort(array);//希尔排序
        long end = System.currentTimeMillis();
        System.out.println("希尔排序：" + (end - begin));
    }




    public static void main(String[] args) {
        /*
          10万个随机数
         */
        int n = 100_0000;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }

        TestSort testSort = new TestSort();
        testSort.testBubbleSort(array);
        testSort.testInsertSort(array);
        testSort.testSelectSort(array);
        //testSort.testQuickSort(array);
        testSort.testShellSort(array);
        testSort.testHeapSort(array);


    }

}

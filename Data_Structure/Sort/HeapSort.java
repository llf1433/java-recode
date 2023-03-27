import java.util.Arrays;
/**
 *  堆排序
 *  时间复杂度：O(N*logN)
 *  空间复杂度：O(1)
 *  稳定性：不稳定
 */

public class HeapSort {
    public static void sort(int[] array) {
        //排升序 建大堆 -- 排降序 建小堆
        createHeap(array);
        int i = array.length - 1;
        while (i >= 0) {
            SelectSort.swap(array,0,i);
            shiftDown(array,0,i);
            i--;
        }
    }

    private static void createHeap(int[] array) {
        for (int parent = (array.length -1-1)/2; parent <= 0; parent++) {
            shiftDown(array, parent, array.length);//向下调整
        }
    }

    private static void shiftDown(int[] array, int parent, int end) {
        int child = 2 * parent + 1;//默认有左孩子
        while (child < end) {
            //找孩子中最大的
            if (child + 1 < end &&  array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                SelectSort.swap(array, child, parent);
                /*
                继续向下调整
                 */
                parent = child;
                child = 2 * parent - 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,1,0};
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

import java.util.Arrays;
/**
 *  快速排序
 *  时间复杂度：O(N*logN)
 *  空间复杂度：O(logN)
 *  稳定性：不稳定
 */
public class QuickSort {

    //递归实现--
    public static void quickSort(int[] array){
        quick(array,0, array.length - 1);
    }
    private static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = searchKey(array, left, right);
        quick(array, left, key - 1);
        quick(array, key + 1, right);
    }


    private static int searchKey(int[] array, int left, int right) {
        int i = left;//基准下标 -- array[i] 为基准值
        while (left < right) {
            /*
                left < right 保证不会越界
                如果是有序  left先走可能会使第一数与最后一个数交换
             */
            while (left < right && array[right] >= array[i]) {
                right--;
            }
            //right 右边都比基准大 right下标值小于基准值
            while (left < right && array[left] <= array[i]) {
                left++;
            }
            //left 左边都比基准大 left下标值大于基准值
            SelectSort.swap(array, left,right);
        }
        SelectSort.swap(array, left, i);
        return right;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,4,1,2,1};
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}

import java.util.Arrays;
/**
 *  选择排序
 *  时间复杂度：O(n^2)
 *  空间复杂度：O(1)
 *  稳定性：不稳定
 */
public class SelectSort {
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int mi = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[mi]) {
                    mi = j;
                }
            }
            if (i != mi) {
                swap(array,i, mi);
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,1,0};
        SelectSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

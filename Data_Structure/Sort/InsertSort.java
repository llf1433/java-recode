import java.util.Arrays;
/**
 *  插入排序
 *  时间复杂度：O(n^2)
 *  空间复杂度：O(1)
 *  稳定性：稳定
 */
public class InsertSort {
    public static void sort(int[] array) {
        //第一个元素默认有序
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
                j--;
            }
            array[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,1,0};
        InsertSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

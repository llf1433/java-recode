import java.util.Arrays;
/**
 *  希尔排序
 *  时间复杂度：O(n^1.3) --平均
 *  空间复杂度：O(1)
 *  稳定性：不稳定
 */
public class ShellSort {
    public static void sort(int[] array) {
        int group = array.length;
        while (group > 1) {
            group /= 2;
            sort(array, group);
        }
    }

    //分组的直接插入排序
    private static void sort(int[] array, int group) {
        /*
           i不用后挪group -- i++一趟足以
         */
        for (int i = group; i < array.length; i++) {
            int j = i - group;//到前一个位置
            int tmp = array[i];
            while (j >= 0) {
                if (array[j] > tmp) {
                    array[j + group] = array[j];//向后挪空位
                } else {
                    break;
                }
                j -= group;
            }
            array[j + group] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,1,0};
        ShellSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

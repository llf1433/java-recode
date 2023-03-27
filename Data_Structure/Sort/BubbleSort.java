import java.util.Arrays;
/**
 *  选择排序
 *  时间复杂度：O(n^2)
 *  空间复杂度：O(1)
 *  稳定性：稳定
 */
public class BubbleSort {
    public static void bubbleSort(int[] array){
        //i 是趟数
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;//标记
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    flag = true;
                    SelectSort.swap(array, j+1, j);
                }
            }
            if (!flag) break; //如果没有交换，说明已经有序 无须再走
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,1,0};
        BubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}

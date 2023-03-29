/**
 *  计数排序 -- 局限性 ：范围小，数据集中
 *  时间复杂度：O(n + 范围)
 *  空间复杂度：O(范围)
 *  稳定性：稳定
 */
import java.util.Arrays;

public class CountSort {
    public static void countSort(int[] array) {
        /*
            遍历数组找到最小值和最大值->确定计数数组的大小
         */
        int maxVal = array[0];
        int minVal = array[0];
        //O(n)
        for (int j : array) {
            if (j > maxVal) maxVal = j;
            if (j < minVal) minVal = j;
        }
        /*
            确定计数数组的长度
         */
        int len = maxVal - minVal + 1;
        int[] countArr = new int[len];
        /*
            遍历当前数组 统计每个数字出现的次数 --O(n)
         */
        for (int val : array) {
            countArr[val - minVal]++;//把值转为下标
        }

        int index = 0;
        /*
            遍历计数数组，看每个下标的值是几，就打印几个下标的数据就好了 O(范围 + n)
            范围遍历一次，位置上所有的数的个数加起来等于n
         */
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {

                array[index] = i + minVal;//把下标转为值
                index++;
                countArr[i]--;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {188,2,19,134,29,15};
        countSort(array);
        System.out.println("排序后："+ Arrays.toString(array));
    }

}

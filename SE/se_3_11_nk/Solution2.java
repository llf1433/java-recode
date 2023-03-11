/*
现给出两个有序整型数组，其中array1按升序（从小到大）排序，array2按降序排序，请你将 array1和array2 合并到一个新的数组中，并保持新中的元素按升序排序。
说明:给出 array1 和 array2 及其元素数量n 和 m ，返回合并后的新数组。
*/
import java.util.*;


public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param array1 int整型一维数组 
     * @param n int整型 
     * @param array2 int整型一维数组 
     * @param m int整型 
     * @return int整型一维数组
     */
    public int[] arrayMerge (int[] array1, int n, int[] array2, int m) {
        // write code here
        int p1 = 0;
        int p2 = m - 1;
        int[] ret = new int[n + m];
        int i = 0;
        while (p1 < n && p2 >= 0){
            if (array1[p1] < array2[p2]) {
                ret[i++] = array1[p1++];
            } else {
                ret[i++] = array2[p2--];
            }
        }
        while (p1 < n){
            ret[i++] = array1[p1++];
        }
        while (p2 >= 0){
            ret[i++] = array2[p2--];
        }
        return ret;
    }
}
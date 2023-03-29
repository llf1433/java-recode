import java.util.Arrays;

/**
 *  归并排序
 *  时间复杂度：O(N*logN)
 *  空间复杂度：O(N)
 *  稳定性：稳定
 */
public class MergeSort {
    public static void sort(int[] array) {
        MergeSortChild(array, 0, array.length - 1);

    }

    /*
        递归实现
     */
    public static void MergeSortChild(int[] array, int left, int right) {
        if (left == right) {
            return;
        }

        //分解
        int mid = (left + right) / 2;
        MergeSortChild(array, left, mid);
        MergeSortChild(array, mid + 1, right);

        //合并
        Merge(array, left, mid, right);
    }

    /*
        合并两个数组并且有序
     */
    private static void Merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int ll = mid + 1;
        int[] ret = new int[right - left + 1];
        int k = 0;
        while (l <= mid && ll <= right) {
            if (arr[l] < arr[ll]) {
                ret[k++] = arr[l++];
            } else {
                ret[k++] = arr[ll++];
            }
        }
        while (l <= mid) {
            ret[k++] = arr[l++];
        }
        while (ll <= right) {
            ret[k++] = arr[ll++];
        }


        for (int i = 0; i < ret.length; i++) {
            arr[i + left] = ret[i];
        }
    }


    /*
        非递归实现
        分组进行
     */

    public static void mergeSort(int[] array) {
        int group = 1;//从1开始
        while (group < array.length) {
            for (int i = 0; i < array.length; i += group * 2) {
                int left = i;
                int mid = left + group - 1;//
                int right = mid + group;//

                /*
                    在合并之前判断mid 使mid不能在Merge中越界 控制right不越界
                 */
                if(mid >= array.length) {
                    mid = array.length-1;
                }

                if(right >= array.length) {
                    right = array.length-1;
                }
                Merge(array,left, mid, right);
            }
            group *= 2;
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,1,0,7,6,1,1040145, 27765, 16618, 47478, 12915, 92728,
                95405, 20926, 43735, 7623, 23234, 96183, 82173, 36878, 30176, 35370, 19854, 76643, 93982, 14176, 70153, 41092, 32582, 10939, 87435, 43893, 30929, 16575, 19098, 23980, 98980, 5308, 74574, 32232, 87815, 17809, 79869, 41435, 8542, 5308, 18657, 38248, 78278, 28678, 75368, 5309, 43533, 25799, 70551, 7910, 50702, 53280, 49244, 54698, 59624, 83906, 74127, 70547, 52987, 73908, 77315, 77277, 37086, 22087, 64111, 46498, 17599, 5309, 34772};
        MergeSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}

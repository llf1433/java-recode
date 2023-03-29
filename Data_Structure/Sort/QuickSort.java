import java.util.Arrays;
/**
 *  快速排序
 *  时间复杂度：O(N*logN)
 *  空间复杂度：O(logN)
 *  稳定性：不稳定
 */
public class QuickSort {

    //递归实现--
    public static void sort(int[] array){
        quick(array,0, array.length - 1);
    }
    private static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        //优化2：递归一定层数 改用插入排序
        if (right - left + 1 <= 7) {
            Insert(array,left,right);
            return;
        }
        //优化1：三数取中
        findMidKey(array, left, right);

        //System.out.println("left:" + array[left] + " mid:" + array[(left + right)/2] + " right" + array[right]);

        int key = partition(array, left, right);//Hoare法  ||  挖坑法

        quick(array, left, key - 1);
        quick(array, key + 1, right);
    }

    /*
        交换中间数 -- 三数取中
     */
    private static void findMidKey(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] > array[mid]) {
            if (array[right] > array[left]) {
                return;
            } else if (array[mid] > array[right]) {
                SelectSort.swap(array,mid,left);
            } else {
                SelectSort.swap(array,right,left);
            }
        } else { //left < mid
            if (array[left] > array[right]) {
                return;
            } else if (array[mid] > array[right]) {
                SelectSort.swap(array,left,right);
            } else {
                SelectSort.swap(array,mid,left);
            }
        }
    }


    public static void Insert(int[] array, int left, int right) {
        //第一个元素默认有序
        for (int i = 1 + left; i <= right; i++) {
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



    //Hoare法
    private static int partition(int[] array, int left, int right) {
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
        return left;
    }



    //挖坑法
    private static int partition2(int[] array, int left, int right) {
        int pivot = array[left];//基准
        while (left < right) {
            /*
                left < right 保证不会越界
                如果是有序  left先走可能会使第一数与最后一个数交换
             */
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];//填旧坑 挖新坑
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];//填旧坑 挖新坑
        }
        //相遇  填坑 -- 把基准值放入
        array[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8};
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

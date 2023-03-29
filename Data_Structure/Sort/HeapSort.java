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
        for (int parent = (array.length -1-1)/2; parent >= 0; parent--) {
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
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,1,0,7,6,1,1040145, 27765, 16618, 47478, 12915, 92728,
                95405, 20926, 43735, 7623, 23234, 96183, 82173, 36878, 30176, 35370, 19854, 76643, 93982, 14176, 70153, 41092, 32582, 10939, 87435, 43893, 30929, 16575, 19098, 23980, 98980, 5308, 74574, 32232, 87815, 17809, 79869, 41435, 8542, 5308, 18657, 38248, 78278, 28678, 75368, 5309, 43533, 25799, 70551, 7910, 50702, 53280, 49244, 54698, 59624, 83906, 74127, 70547, 52987, 73908, 77315, 77277, 37086, 22087, 64111, 46498, 17599, 5309, 34772};
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

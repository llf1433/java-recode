import java.util.Arrays;
import java.util.Random;

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
        int n = 10_0000;
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }
        //int[] arr = {1, 3,2,0};
        InsertSort.sort(array);
        //System.out.println(Arrays.toString(array));
    }
}

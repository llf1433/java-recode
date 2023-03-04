import java.lang.reflect.Array;
import java.util.Arrays;

public class Main_3_4 {
    public static void transform(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }
    }

    public static void main1(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        transform(array);
        System.out.println(Arrays.toString(array));
    }


    public static double avg(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum * 1.0 / array.length;
    }

    public static void main2(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        double ret = avg(array);
        System.out.println(ret);
    }

    public static void adjust_eve(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] % 2 == 0) {
                for (; right > left; right--) {
                    if (arr[right] % 2 != 0) {
                        int tmp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = tmp;
                        break;
                    }
                }
            }
            left++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 2, 1, 2, 3, 4, 5, 6};
        adjust_eve(array);
        System.out.println(Arrays.toString(array));
    }


    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1; // == (left + right) / 2
            if (array[mid] < key) {
                left = mid + 1;
            } else if (array[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -(left + 1);

    }
    public static void main4(String [] args) {
        int[] arr = new int[]{1,3,5,7,9,11,13};
        int pos = binarySearch(arr, 9);
        System.out.println(pos);
    }


    //寻找两数之和为targer的下标
    public static int[] sum_two(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = ret[1] = -1;
        if (nums == null || nums.length == 1) {
            return ret;
        }
        int left = 0;
        for (int i = left; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;

    }
    public static void main5(String [] args) {
        int[] nums = new int[]{12,11,7,16,2};
        int target = 9;
        int[] ret = new int[2];
        ret = sum_two(nums, target);
        System.out.println(Arrays.toString(ret));
    }


    public static int appear_once(int[] array) {
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret ^= array[i];//异或^
        }
        return ret;
    }
    //appear once number ？
    public static void main6(String[] args) {
        int[] arr = {4,1,2,1,2};
        int ret = appear_once(arr);
        System.out.println(ret);
    }


    //Most elements (> | n / 2 |)
    //计数排序
    public static void most_elements(int[] array) {
        int maxNum = Arrays.stream(array).max().getAsInt();
        int [] tmpArr = new int[maxNum + 1];
        for (int x : array) {
            tmpArr[x] += 1;
        }
        for (int i = 0; i < tmpArr.length; i++) {
            if (tmpArr[i] > (array.length)*1.0 / 2) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main7(String[] args) {
        //int[] arr = {2,2,1,1,1,2,2};
        int[] arr = {3, 2 ,3};
        most_elements(arr);
    }

    //Concecutive odd (3)
    public static boolean conOdd(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                int count = 3;
                int j = i;
                while (count != 0 && j < array.length) {
                    if (array[j] % 2 == 0) {
                        break;
                    }
                    j++;
                    count--;
                }
                if (count == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main8(String[] args) {
        int[] arr = {1,2,34,3,4,5,7,23,12};
        //int[] arr = {2,4,6,1};
        boolean ret = conOdd(arr);
        System.out.println(ret);
    }
}
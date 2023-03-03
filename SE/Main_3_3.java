public class Main_3_3 {
    public static int fac(int n) {
        if (n == 1){
            return 1;
        }
        return n * fac(n - 1);
    }
    public static void main1(String [] args) {
        int t = fac(5);
        System.out.println(t);
    }



    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
    public static void main2(String [] args){
        int t = sum(10);
        System.out.println(t);
    }


    public static void print (int n) {
        if (n < 10) {
            System.out.print(n);
            return;
        }
        print(n / 10);
        System.out.print(n % 10);
    }
    public static void main3(String[] args) {
        int n = 1234;
        print(n);
    }

    public static int sum_bit(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sum_bit(n / 10);
    }
    public static void main4(String[] args) {
        int num = 1234;
        int s = sum_bit(num);
        System.out.println(s);
    }

    public static int fib_n(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib_n(n - 1) + fib_n(n - 2);
    }
    public static void main5(String[] args) {
        int fc_n = fib_n(5);
        System.out.println(fc_n);
    }


    public static void hanio(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            move(pos1,pos3);
            return;
        }
        hanio(n - 1, pos1, pos3, pos2);
        move(pos1, pos3);
        hanio(n - 1,pos2, pos1, pos3);
    }

    public static void move(char pos1, char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }

    //汉诺塔
    public static void main7(String[] args) {
        hanio(3, 'A', 'B', 'C');
    }


    public static void main6(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }


    public static void printArray(int[] array) {
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,4,5,1,4};
        printArray(arr);
    }


}

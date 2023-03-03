import java.util.Scanner;

public class Main_3_2 {

    public static int  max2(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static int max3(int a, int b, int c) {
        return max2(max2(a, b),c);
    }
    public static void main1(String[] args) {
        int x = 10;
        int y = 20;
        int z = 90;
        int max = max2(x,y);
        System.out.println(max);
        int m = max3(x,z,y);
        System.out.println(m);
    }


    public static int fac(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    public static int sum_fac(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fac(i);
        }
        return sum;
    }

    public static void main2(String [] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ret_s = sum_fac(n);
        System.out.println(ret_s);
    }


    public static int fib(int n) {
        int f1 = 1,f2 = 1;
        if (n <= 2) {
            return f1;
        }
        int f = 0;
        for (int i = 3; i <= n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }

    public static void main3(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ret = fib(n);
        System.out.println(ret);
    }


    public static int sum(int a, int b) {
        return a + b;
    }

    public static double sum(double a, double b, double c) {
        return a + b + c;

    }
    public static void main4(String[] args) {
        int x = 10, y = 20;
        double f = 12.1, sc = 11.3, tw = 19.1;
        int s = sum(x, y);
        double ss = sum(f, sc , tw);
        System.out.println(s + " " + ss);
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }


    public static double max(double a, double b, double c) {
    double max = a > b ? a : b;
    max = max > c ? max : c;
    return max;
    }

    public static void main5(String [] args) {
        int x = 10, y = 20;
        double f = 12.1, sc = 11.3, tw = 19.1;
        int mx = max(x, y);
        double mfx = max(f, sc, tw);
        System.out.println(mx);
        System.out.println(mfx);
    }




    /*public static void print(int n) {
        if (n < 10) {
            System.out.print(n + " ");
            return;
        }
        print(n / 10);
        System.out.print(n % 10 + " ");
    }*/


    public static int print(int n) {
        if (n < 10) {
            //System.out.print(n + " ");
            return n;
        }
        return n % 10 +  print(n / 10);


    }
    public static void main6(String [] args) {
        int n = 106;
        int p = print(n);
        System.out.println(p);
    }





}
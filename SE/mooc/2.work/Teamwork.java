import java.util.Scanner;
import java.util.Arrays;

public class Teamwork {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n % 2 == 1) {
            System.out.println("odd number");
            return;
        }
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = input.nextInt();
        }
        Arrays.sort(ids);
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            System.out.printf("%d %d\n", ids[i], ids[j]);
        }
    }
}


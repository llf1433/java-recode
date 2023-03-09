import java.util.Scanner;

public class sum_integer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        if (nums < 1 || nums > 100) {
            System.out.println("error");
            System.exit(0);
        }
        int sum = 0;
        for (int i = 0; i < nums; i++) {
            int si = scanner.nextInt();
            if (si >= 800) {
                System.out.println("error");
                System.exit(0);
            }
            if (si < 800)
                sum += si;
        }
        System.out.println(sum);
    }
}
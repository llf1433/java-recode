import java.util.Scanner;

public class elec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        double y = 0.0;
        if (x <= 100) {
            y = x * 0.3;
        } else if (x <= 200) {
            y = x * 0.4;
        } else if (x <= 300) {
            y = x * 0.5;
        } else {
            y = x * 0.8;
        }
        System.out.println(y);
    }
}

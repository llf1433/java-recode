import java.util.Scanner;

public class CF_convert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();
        int c = (f - 32) * 5 / 9; // 注意需要加上 0.5 并将结果强制转换为整数
        System.out.println(c);
    }
}
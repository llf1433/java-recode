import java.util.Scanner;

public class _24to_12{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.next();
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        String suffix = hour >= 12 && hour != 24 ? "PM" : "AM";
        hour = hour % 12 == 0 ? 12 : hour % 12; // 将24小时制的小时数转换成12小时制
        System.out.printf("%02d:%02d %s\n", hour, minute, suffix); // %02d表示输出2位数，不足2位则前面补0
    }
}

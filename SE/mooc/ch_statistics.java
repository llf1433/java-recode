import java.util.Scanner;
public class ch_statistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase(); // 将输入字符串转换为小写字母
        int[] count = new int[26]; // 记录每个字母出现次数的数组
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') { // 如果当前字符是字母
                count[c - 'a']++; // 将对应字母的计数器加 1
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) { // 如果当前字母出现过，则输出其出现次数
                System.out.print((char) ('a' + i) + "=" + count[i] + "  ");
            }
        }
        System.out.println(); // 输出换行符
    }
}
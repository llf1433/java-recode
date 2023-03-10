public class leetcode387 {
    public int firstUniqChar(String s) {
        char[] arr = new char[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }


    //NK
    public static int lastStrLegth(String s) {
        int lastlength = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lastlength++;
            } else {
                return lastlength;
            }
        }
        return lastlength;
    }


    public static void main(String[] args) {
        //char[] arr = new char[26];
        int le = lastStrLegth("hello word");
        System.out.println(le);
    }

}

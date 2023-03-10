import java.util.HashMap;

public class Main {
    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] array = str.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);

            //当前 key 是否存在
            if (map.containsKey(key)) {
                if (!map.get(key).equals(array[i])) {
                    return false;
                }
            } else {
                if(map.containsValue(array[i])) {
                    return false;
            }
                map.put(key, array[i]);
            }
        }
        return true;
    }
    public static void main(String [] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean ft = wordPattern(pattern,s);
        System.out.println(ft);
    }
}
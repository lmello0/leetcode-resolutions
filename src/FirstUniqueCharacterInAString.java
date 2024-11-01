import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        Map<Character, Integer[]> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);

            if (map.containsKey(key)) {
                map.get(key)[1]++;
            } else {
                map.put(key, map.getOrDefault(key, new Integer[]{i, 1}));
            }
        }

        for (Map.Entry<Character, Integer[]> entry : map.entrySet()) {
            if (entry.getValue()[1] == 1) {
                return entry.getValue()[0];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}

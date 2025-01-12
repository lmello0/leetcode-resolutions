import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public String minWindow(String s,  String t) {
        if (t.isEmpty() || t.length() > s.length()) return "";

        Map<Character, Integer> countT = new HashMap<>();

        for (Character c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();

        int resStart = -1;
        int resEnd = -1;
        int resLen = Integer.MAX_VALUE;

        int left = 0;
        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char chrRight = s.charAt(right);
            window.put(chrRight, window.getOrDefault(chrRight, 0) + 1);

            if (countT.containsKey(chrRight) && Objects.equals(window.get(chrRight), countT.get(chrRight))) {
                have++;
            }

            while (have == need) {
                int windowSize = right - left + 1;

                if (windowSize < resLen) {
                    resStart = left;
                    resEnd = right;

                    resLen = windowSize;
                }

                char chrLeft = s.charAt(left);
                window.put(chrLeft, window.get(chrLeft) - 1);

                if (countT.containsKey(chrLeft) && window.get(chrLeft) < countT.get(chrLeft)) {
                    have--;
                }

                left++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resEnd + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

        System.out.println(minimumWindowSubstring.minWindow("OUZODYXAZV", "XYZ"));
    }
}

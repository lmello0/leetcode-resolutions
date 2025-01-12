import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;

            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }

    public boolean checkInclusion_map(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();

        for (int i = 'a'; i <= 'z'; i++) {
            s1Count.put((char) i, 0);
            s2Count.put((char) i, 0);
        }

        for (int i = 0; i < s1.length(); i++) {
            s1Count.put(s1.charAt(i), s1Count.get(s1.charAt(i)) + 1);
            s2Count.put(s2.charAt(i), s2Count.get(s2.charAt(i)) + 1);
        }

        int matches = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (Objects.equals(s1Count.get((char) i), s2Count.get((char) i))) {
                matches++;
            }
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;

            char chrRight = s2.charAt(right);
            s2Count.put(chrRight, s2Count.get(chrRight) + 1);

            if (Objects.equals(s1Count.get(chrRight), s2Count.get(chrRight))) {
                matches++;
            } else if (Objects.equals(s1Count.get(chrRight) + 1, s2Count.get(chrRight))) {
                matches--;
            }

            char chrLeft = s2.charAt(left);
            s2Count.put(chrLeft, s2Count.get(chrLeft) - 1);

            if (Objects.equals(s1Count.get(chrLeft), s2Count.get(chrLeft))) {
                matches++;
            } else if (Objects.equals(s1Count.get(chrLeft) - 1, s2Count.get(chrLeft))) {
                matches--;
            }

            left++;
        }

        return matches == 26;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";

        PermutationInString pis = new PermutationInString();

        System.out.println(pis.checkInclusion_map(s1, s2));
    }
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int j : nums) {
            set.add(j);
        }

        int[] arr = new int[set.size()];
        int index = 0;
        for (int num : set) {
            arr[index++] = num;
        }

        Arrays.sort(arr);

        int res = 1;
        int curSeq = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 == arr[i]) {
                curSeq++;
            } else {
                curSeq = 1;
            }

            res = Math.max(res, curSeq);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
    }
}
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        int right = 0;

        Set<Integer> set = new HashSet<>();

        while (right < nums.length) {
            if (set.contains(nums[right])) {
                return true;
            }

            set.add(nums[right]);

            while (right - left >= k) {
                set.remove(nums[left]);
                left++;
            }

            right++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}

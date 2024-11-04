import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        final int TARGET = 0;
        Set<List<Integer>> setRes = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == TARGET) {
                    List<Integer> zero = new ArrayList<>();

                    zero.add(nums[i]);
                    zero.add(nums[left]);
                    zero.add(nums[right]);

                    setRes.add(zero);

                    do {
                        left++;
                    } while (nums[left] == nums[left - 1] && left < right);

                } else if (sum > TARGET) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return setRes.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}

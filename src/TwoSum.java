import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
}

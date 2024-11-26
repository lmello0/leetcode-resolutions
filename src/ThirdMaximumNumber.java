import java.util.Arrays;

public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int count = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i-1]) {
                count++;
            }

            if (count == 3) {
                return nums[i - 1];
            }
        }

        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3,2,1}));
        System.out.println(thirdMax(new int[]{1,2}));
        System.out.println(thirdMax(new int[]{2,2,3,1}));
        System.out.println(thirdMax(new int[]{5,2,2}));
    }
}

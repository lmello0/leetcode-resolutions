public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int total = 0;

        for (int n : nums) {
            if (total < 0) {
                total = 0;
            }

            total += n;
            res = Math.max(res, total);
        }

        return res;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}

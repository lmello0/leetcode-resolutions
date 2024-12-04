public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int j = 0;

        int prod = 1;
        int res = 0;

        while (j < nums.length) {
            prod *= nums[j];

            while (prod >= k && i <= j) {
                prod /= nums[i];
                i++;
            }

            res += j - i + 1;
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int x = 0;

        for (int num : nums) {
            x ^= num;
        }

        for (int i = 0; i <= nums.length; i++) {
            x ^= i;
        }

        return x;
    }

    public static void main(String[] args) {
        missingNumber(new int[]{3,0,1});
    }
}

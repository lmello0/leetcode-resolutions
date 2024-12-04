import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }

        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre *= nums[i];
        }

        int post = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * post;
            post *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 3, 9, 2, 7 })));
    }
}

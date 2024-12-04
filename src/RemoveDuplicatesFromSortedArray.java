public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int res = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                continue;
            }

            nums[res] = nums[i];

            res++;
            prev = nums[i];
        }

        return res;
    }

    public static int removeDuplicates2(int[] nums) {
        int left = 1;
        int right = 1;

        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];

                left++;
            }

            right++;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates2(arr));
    }
}
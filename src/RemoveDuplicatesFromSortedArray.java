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

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(arr);

        System.out.println(k);

        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }
}
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int countNegative1 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                break;
            }

            if (prev == nums[i]) {
                int behind = i;
                int next = i + 1;

                nums[i] = Integer.MIN_VALUE;
                countNegative1++;
                while (next < nums.length) {
                    int tmp = nums[behind];

                    nums[behind] = nums[next];
                    nums[next] = tmp;

                    next++;
                    behind++;
                }

                i--;
            }

            prev = nums[i];
        }

        return nums.length - countNegative1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3,-1,0,0,0,3,3};

        int k = removeDuplicates(arr);

        System.out.println(k);

        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }
}
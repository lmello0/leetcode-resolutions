package sort;

public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        int size = nums.length;

        for (int ignored = 0; ignored < size; ignored++) {
            boolean sorted = true;
            for (int i = 0; i < size - 1 - ignored; i++) {
                if (nums[i] > nums[i + 1]) {
                    sorted = false;
                    int tmp = nums[i];

                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmp;
                }
            }

            if (sorted) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{5,4,3,2,1});
    }
}

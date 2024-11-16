package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pi = partition(nums, left, right);

            quickSort(nums, left, pi-1);
            quickSort(nums, pi+1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left-1;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;

                int tmp = nums[i];

                nums[i] = nums[j];
                nums[j] = tmp;
            }

        }

        int tmp = nums[i + 1];

        nums[i + 1] = nums[right];
        nums[right] = tmp;

        return i+1;
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,8,4,9,3,7,2,90,3,6,2,78,23,6782,67,3,7,12,7,123,9,2,8};

//        System.out.println(Arrays.toString(nums));

        quickSort(nums);

//        System.out.println(Arrays.toString(nums));
    }
}

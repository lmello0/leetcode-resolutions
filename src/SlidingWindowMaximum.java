import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return new int[]{};
        }

        int left = 0;
        int[] res = new int[nums.length - k + 1];

        for (int right = 0; right < nums.length; right++) {
            if ((right - left + 1) % k == 0) {
                int max = Integer.MIN_VALUE;
                for (int i = left; i <= right; i++) {
                    max = Math.max(max, nums[i]);
                }

                res[left] = max;
                left++;
            }
        }

        return res;
    }

    public int[] maxSlidingWindow_Optimal(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int resIdx = 0;
        int left = 0;
        int right = 0;

        Deque<Integer> q = new LinkedList<>();

        while (right < nums.length) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[right]) {
                q.pollLast();
            }

            q.add(right);

            if (left > q.peekFirst()) {
                q.pollFirst();
            }

            if (right + 1 >= k) {
                res[resIdx++] = nums[q.peekFirst()];
                left++;
            }

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow_Optimal(new int[]{1,2,1,0,4,2,6}, 3)));
    }
}

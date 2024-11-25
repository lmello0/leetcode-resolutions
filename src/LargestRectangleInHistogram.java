import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();

                int index = top[0];
                int height = top[1];

                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }

            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];

            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
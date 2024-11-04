import java.util.Arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int max = 0;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int length = right - left;

            int area = height * length;

            max = Math.max(max, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}

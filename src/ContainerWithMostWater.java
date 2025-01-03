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

    public int maxArea2(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int max = 0;

        while (left < right) {
            int currMax = Math.min(heights[left], heights[right]) * (right - left);

            max = Math.max(max, currMax);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        System.out.println(containerWithMostWater.maxArea2(new int[]{7,1,7,2,2,4}));
    }
}

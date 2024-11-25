import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];

            while (!stack.isEmpty() && t > stack.peek()) {
                int index = stack.pop();
                res[index] = i - index;
            }

            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
    }
}

// [30,40,50,60]
// [ 1, 1, 1, 0]
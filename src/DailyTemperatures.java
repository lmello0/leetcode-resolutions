import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];

            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }

            stack.push(new int[]{t, i});
        }

        return res;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{30,40,50,60});
    }
}

// [30,40,50,60]
// [ 1, 1, 1, 0]
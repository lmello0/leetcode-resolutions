import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    private final static Stack<String> stack = new Stack<>();
    private final static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);

        return res;
    }

    private static void backtrack(int n, int openCount, int closedCount) {
        if (openCount == closedCount && openCount == n) {
            res.add(String.join("", stack));
            return;
        }

        if (openCount < n) {
            stack.push("(");
            backtrack(n, openCount + 1, closedCount);
            stack.pop();
        }

        if (closedCount < openCount) {
            stack.push(")");
            backtrack(n, openCount, closedCount + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}

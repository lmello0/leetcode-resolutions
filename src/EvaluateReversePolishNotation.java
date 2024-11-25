import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = numStack.pop();
                int num2 = numStack.pop();

                int result = calculate(num2, num1, token);

                numStack.push(result);
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }

        return numStack.pop();
    }

    private static int calculate(int num1, int num2, String op) {
        return switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalStateException("Unexpected value: " + op);
        };
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}

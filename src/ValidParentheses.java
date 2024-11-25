import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char chr = s.charAt(i);

            if (chr == '(' || chr == '[' || chr == '{' )  {
                stack.push(chr);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char poppedChar = stack.pop();
            if (chr == ')' && poppedChar != '(') {
                return false;
            }

            if (chr == ']' && poppedChar != '[') {
                return false;
            }

            if (chr == '}' && poppedChar != '{') {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([])")); // true
        System.out.println(isValid("([(])")); // false
        System.out.println(isValid("){")); // false
        System.out.println(isValid("(])")); // false
        System.out.println(isValid("(){}}{")); // false
    }
}

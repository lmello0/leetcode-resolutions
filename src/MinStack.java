import java.util.Stack;

public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }

    public void pop() {
        int removed = stack.pop();

        if (removed == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();

        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.push(0);

        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

package dataStructures;

import java.util.EmptyStackException;
import java.util.Stack;

public class LinkedListStack {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private int size = 0;
    private Node top = null;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = this.top;

        this.top = newNode;
        this.size++;
    }

    public int pop() {
        if (this.top == null) {
            throw new EmptyStackException();
        }

        Node popped = this.top;

        this.top = popped.next;
        this.size--;

        return popped.value;
    }

    public int peek() {
        if (this.top == null) {
            throw new EmptyStackException();
        }

        return this.top.value;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

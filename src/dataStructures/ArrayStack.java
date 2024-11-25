package dataStructures;

import java.util.EmptyStackException;

public class ArrayStack<T> {
    private final T[] array;
    private int pointer;

    public ArrayStack(int maxLength) {
        this.array = (T[]) new Object[maxLength];
    }

    public void push(T item) {
        this.array[pointer] = item;
        this.pointer++;
    }

    public T pop() {
        if (this.array.length == 0) {
            throw new EmptyStackException();
        }

        T item = this.array[pointer];

        this.array[pointer] = null;
        this.pointer--;

        return item;
    }

    public T peek() {
        if (this.array.length == 0) {
            throw new EmptyStackException();
        }

        return this.array[this.pointer];
    }

    public int size() {
        return this.pointer;
    }
}

package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap = new ArrayList<>();

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = this.parent(index);

        if (this.heap.get(index) < this.heap.get(parentIndex)) {
            int tmp = this.heap.get(index);

            this.heap.set(index, this.heap.get(parentIndex));
            this.heap.set(parentIndex, tmp);

            this.heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int size = this.heap.size();

        int left = this.leftChild(index);
        int right = this.rightChild(index);

        int smallest = index;

        if (left < size && this.heap.get(left) < this.heap.get(smallest)) {
            smallest = left;
        }

        if (right < size && this.heap.get(right) < this.heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            int tmp = this.heap.get(index);

            this.heap.set(index, this.heap.get(smallest));
            this.heap.set(smallest, tmp);

            this.heapifyDown(smallest);
        }
    }

    public void insert(int value) {
        this.heap.add(value);

        this.heapifyUp(this.heap.size() - 1);
    }

    public int pop() {
        if (this.heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        if (this.heap.size() == 1) {
            return this.heap.removeLast();
        }

        int root = this.heap.getFirst();

        this.heap.set(0, this.heap.removeLast());
        this.heapifyDown(0);

        return root;
    }

    public void display() {
        System.out.println(this.heap);
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.insert(0);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(0);
        heap.insert(0);

        heap.display();
    }
}

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.minHeap.addAll(Arrays.stream(nums).boxed().toList());
        this.k = k;

        while (this.minHeap.size() > this.k) {
            this.minHeap.remove();
        }
    }

    public int add(int val) {
        this.minHeap.offer(val);

        if (this.minHeap.size() > this.k) {
            this.minHeap.remove();
        }

        return this.minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream obj = new KthLargestElementInAStream(3, new int[]{4,5,8,2});

        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();

        t.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        t.topKFrequent(new int[]{1}, 1);
    }
}
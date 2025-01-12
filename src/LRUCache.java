import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        final int val;
        final int key;

        Node prev = null;
        Node next = null;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;

    private final Node left;
    private final Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);

        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);

            this.remove(node);
            this.insert(node);

            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            this.remove(this.cache.get(key));
        }

        Node node = new Node(key, value);
        this.cache.put(key, node);

        this.insert(node);

        if (this.cache.size() > this.capacity) {
            Node lru = this.left.next;
            this.remove(lru);
            this.cache.remove(lru.key);
        }
    }

    // remove node from list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // insert node at right
    private void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}

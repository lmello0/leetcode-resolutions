import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node {
        public int key;
        public int value;

        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;

            this.prev = null;
            this.next = null;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            this.remove(this.cache.get(key));
            this.insert(this.cache.get(key));

            return this.cache.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            this.remove(this.cache.get(key));
        }

        this.cache.put(key, new Node(key, value));
        this.insert(this.cache.get(key));

        if (this.cache.size() > this.capacity) {
            Node lru = this.tail.prev;

            this.remove(lru);
            this.cache.remove(lru.key);
        }
    }

    private void remove(Node removeNode) {
        Node prev = removeNode.prev;
        Node next = removeNode.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node insertNode) {
        Node prev = this.head;
        Node next = this.head.next;

        prev.next = insertNode;
        next.prev = insertNode;

        insertNode.next = next;
        insertNode.prev = prev;
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

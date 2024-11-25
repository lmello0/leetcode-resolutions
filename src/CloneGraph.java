import java.util.*;

public class CloneGraph {
    private static class Node {
        public int val;

        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Deque<Node> queue = new LinkedList<>();
        Map<Integer, Node> clones = new HashMap<>();

        queue.add(node);
        clones.put(node.val, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node curr = queue.removeFirst();
            Node currClone = clones.get(curr.val);

            for (Node n : curr.neighbors) {
                if (!clones.containsKey(n.val)) {
                    clones.put(n.val, new Node(n.val, new ArrayList<>()));
                    queue.add(n);
                }

                currClone.neighbors.add(clones.get(n.val));
            }
        }

        return clones.get(node.val);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node4);

        node3.neighbors.add(node1);
        node3.neighbors.add(node4);

        node4.neighbors.add(node2);
        node4.neighbors.add(node3);

        cloneGraph(node1);
    }
}

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node() {
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node node = new Node(curr.val);

            map.put(curr, node);

            curr = curr.next;
        }

        Node res = new Node(0);
        Node currRes = res;
        curr = head;
        while (curr != null) {
            Node node = map.get(curr);
            node.random = map.get(curr.random);

            currRes.next = node;

            currRes = currRes.next;
            curr = curr.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        Node node_3 = new Node(3);
        Node node_7 = new Node(7);
        Node node_4 = new Node(4);
        Node node_5 = new Node(5);

        node_3.next = node_7;
        node_3.random = null;

        node_7.next = node_4;
        node_7.random = node_5;

        node_4.next = node_5;
        node_4.random = node_3;

        node_5.next = null;
        node_5.random = node_7;

        new CopyLinkedListWithRandomPointer().copyRandomList(node_3);
    }
}

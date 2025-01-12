import utils.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode ahead = head.next;

        while (ahead != null && ahead.next != null) {
            ahead = ahead.next.next;
            head = head.next;

            if (head == ahead) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_1;

        new LinkedListCycle().hasCycle(node_1);
    }
}

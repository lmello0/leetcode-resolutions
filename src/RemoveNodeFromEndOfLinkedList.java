import utils.ListNode;

public class RemoveNodeFromEndOfLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;

        new RemoveNodeFromEndOfLinkedList().removeNthFromEnd(node_1, 2);
        new RemoveNodeFromEndOfLinkedList().removeNthFromEnd(new ListNode(5), 1);
    }
}

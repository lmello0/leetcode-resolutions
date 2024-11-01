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
}

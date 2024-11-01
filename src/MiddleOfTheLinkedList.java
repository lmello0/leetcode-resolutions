import utils.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode ahead = head;

        while (ahead != null && ahead.next != null) {
            ahead = ahead.next.next;
            head = head.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}

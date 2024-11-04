import utils.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode newList = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newList;

            newList = head;
            head = nextNode;
        }

        return newList;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);

        list.next = new ListNode(2);
        list.next.next = new ListNode(3);

        reverseList(list);
    }
}

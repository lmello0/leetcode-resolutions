import utils.ListNode;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }

            curr = prev.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);

        // 1,2,6,3,4,5,6

        list.append(2);
        list.append(6);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);

        removeElements(list, 6);
    }
}

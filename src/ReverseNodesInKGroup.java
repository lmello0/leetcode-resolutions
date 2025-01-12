import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> lists = new ArrayList<>();

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int i = 0;
        while (head != null) {
            if (i % k == 1) {
                break;
            }

            curr.next = head;
            head = head.next;

            i++;
        }

        return new ListNode();
    }

    private ListNode reverseList(ListNode head) {
        ListNode node = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = node;

            node = head;
            head = nextNode;
        }

        return node;
    }

    public static void main(String[] args) {
        new ReverseNodesInKGroup().reverseKGroup();
    }
}

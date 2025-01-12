import utils.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int val = val1 + val2 + carry;
            carry = val / 10;

            val = val % 10;

            curr.next = new ListNode(val);

            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);

        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_6 = new ListNode(6);

        node_1.next = node_2;
        node_2.next = node_3;

        node_4.next = node_5;
        node_5.next = node_6;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(new ListNode(9), new ListNode(9));
    }
}

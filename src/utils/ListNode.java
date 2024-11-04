package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void append(int val) {
        ListNode node = new ListNode(val);

        if (this.next == null) {
            this.next = node;
            return;
        }

        ListNode last = this.next;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
    }
}

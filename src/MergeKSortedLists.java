import utils.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (ListNode list : lists) {
            ListNode curr = list;

            while (curr != null) {
                q.offer(curr.val);

                curr = curr.next;
            }
        }

        if (q.isEmpty()) {
            return null;
        }

        ListNode merged = new ListNode(q.poll());
        ListNode curr = merged;

        while (!q.isEmpty()) {
            curr.next = new ListNode(q.poll());
            curr = curr.next;
        }

        return merged;
    }

    public ListNode mergeKLists_Optimal(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode merged = lists[0];
        for (int i = 1; i < lists.length; i++) {
            merged = mergeTwoLists(merged, lists[i]);
        }

        return merged;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        ListNode m = new MergeKSortedLists().mergeKLists_Optimal(lists);
    }
}

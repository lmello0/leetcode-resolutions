import utils.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }

            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    public ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null && list2 == null) {
            curr.next = list2;
        } else if (list1 == null && list2 != null) {
            curr.next = list1;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);

        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(1);

        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        new MergeTwoSortedLists().mergeTwoLists_2(list1, list2);
    }
}

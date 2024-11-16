package sort;

public class MergeSort {
    private static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public Node() {
            this.val = 0;
            this.next = null;
        }
    }

    private static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node merge(Node list1, Node list2) {
        Node head = new Node();
        Node tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head.next;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = findMiddle(head);
        Node afterMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(afterMiddle);

        return merge(left, right);
    }

    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node1 = new Node(1, node7);
        Node node3 = new Node(3, node1);
        Node node9 = new Node(9, node3);

        mergeSort(node9);
    }
}

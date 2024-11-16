package dataStructures;

public class LinkedList<T> {

    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node<T> startNode) {
        this.head = startNode;
    }

    public LinkedList(T val) {
        this.head = new Node<>(val);
    }

    public void traverse() {
        Node<T> current = head;

        System.out.print("[");
        while(current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.println("]");
    }

    public void add(T val) {
        Node<T> newNode = new Node<>(val);
        Node<T> current = head;

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        while(current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void remove(T val) {
        Node<T> current = head;
        Node<T> previous = head;

        while (current != null) {
            if (current.val == val) {
                if (current == head) {
                    head = head.next;
                }

                previous.next = current.next;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public class Node<T> {
        private Node<T> next;
        private T val;

        public Node(T val) {
            this.next = null;
            this.val = val;
        }

        public Node(T val, Node<T> next) {
            this.next = next;
            this.val = val;
        }

        public Node(Node<T> next) {
            this.next = next;
            this.val = null;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Lucas");
        list.add("Mello");
        list.add("dos");
        list.add("Santos");

        list.traverse();

        list.remove("Mello");

        list.traverse();
    }
}

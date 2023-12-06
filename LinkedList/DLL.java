package LinkedList;

public class DLL {

    private int size;
    private Node head;
    private Node tail;

    public DLL() {
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);

        if (tail == null){
            tail = head;
        }
        node.next = head;
        node.prev = null;
        if (head != null){
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node temp = head;

        node.next = null;
        tail = node;

        if(head == null){
            node.prev = null;
            head = node;
            return;
        }

        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
        node.prev = temp;
    }

    public void display() {
        Node node = head;
        while (node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("ENDs");
    }

    public void displayReverse() {
        Node node = tail;
        while (node != null){
            System.out.print(node.value + " -> ");
            node = node.prev;
        }
        System.out.println("ENDs");
    }



    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int val){
            this.value = val;
        }

        public Node(int val, Node next, Node prev) {
            this.value = val;
            this.next = next;
            this.prev = prev;
        }

    }

}

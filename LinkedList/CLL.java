package LinkedList;

public class CLL {

    private Node head;
    private Node tail;
    private int size;

    public CLL() {
        this.size = 0;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int val){
        if(head == null){
            return;
        }
        Node temp = head;

        if(temp.value == val){
            tail.next = head.next;
            head = head.next;
            return;
        }
        do {
            Node n = temp.next;
            if(n.value == val){
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        } while(temp != head);
    }

    public void display(){
        Node temp = head;
        if (head != null){
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("HEAD");
    }
    private class Node {
        private int value;
        private Node next;

        public Node(int val){
            value = val;
        }

        public Node(int val, Node next){
            value = val;
            this.next = next;
        }
    }
}

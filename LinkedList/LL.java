package LinkedList;

public class LL {

    private int size;
    private Node head;
    private Node tail;

    public LL() {
        this.size = 0;
    }
    
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node find(int val){
        Node node = head;
        while (node != null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;

        if( head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if( size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return value;
    }

    public int delete(int index){
        if (index == 0){
            return deleteFirst();
        } else if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index -1);
        int val = prev.next.value;

        prev.next = prev.next.next;

        return val;
    }

    public void insert(int val, int index) {
        if (index == 0){
            insertFirst(val);
            return;
        } else if (index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    // insert using recursion
    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index--, node.next);
        return node;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail ==  null){
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size += 1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void bubbleSort() {
        bubbleSort(size-1, 0);
    }

    private void bubbleSort(int r, int c) {
        if( r == 0) {
            return;
        }

        if( c < r){
            Node first = get(c);
            Node second = get (c + 1);
            if (first.value > second.value){
                //swap
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if(second == tail) {
                    Node prev = get(c - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(c - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(r, c + 1);
        } else {
            bubbleSort(r-1 ,c);
        }
    }


    //recursion reverse
    private void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }

        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //in-place reversal
    private void reverse2(Node node) {
        if(node == null){
            head=tail;
            return;
        } else if (node == tail) {
            head=tail;
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        head = prev;

    }




    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

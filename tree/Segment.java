package tree;

public class Segment {

    public static void main(String[] args) {

    }
    public class Node {
        private int data;
        private int startInterval;
        private int endInterval;
        private Node left;
        private Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

        public int getData(){
            return this.data;
        }
    }

    private Node root;

    public Segment(int[] arr){
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        Node root;
        if (start == end){
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        //create new node with index where you at
        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display(){
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null){
            str = str + "Interval = [" + node.left.startInterval + "-" + node.left.endInterval + "] and data: "+ node.left.data + " --> ";
        } else {
            str = str + "No left child ";
        }

        //for current node
        str = str + "Interval = [" + node.startInterval + "-" + node.endInterval + "] and data: "+ node.data + " <-- ";

        if (node.right != null){
            str = str + "Interval = [" + node.right.startInterval + "-" + node.right.endInterval + "] and data: "+ node.right.data;
        } else {
            str = str + "No right child ";
        }

        System.out.println(str +"\n");

        //recursion call
        if (node.left != null){
            display(node.left);
        }
        if (node.right != null){
            display(node.right);
        }
    }

    //query
    public int query(int qs, int qe){
        return this.query(this.root, qs, qe);
    }

    private int query(Node node, int qs, int qe) {
        if (node.startInterval >= qs && node.endInterval <= qe){
            //node is lying completely in query
            return node.data;
        } else if (node.startInterval > qe || node.endInterval < qs) {
            // node is partially lying in query
            return 0;
        } else {
            return this.query(node.left, qs, qe) + this.query(node.right, qs, qe);
        }
    }


    //update
    public int update(int index, int data){
        this.root.data = update(this.root, index, data);
        return this.root.data;

    }

    private int update(Node node, int index, int data) {
        if (index >= node.startInterval && index <= node.endInterval){
            if (index == node.startInterval && index == node.endInterval){
                node.data = data;
                return node.data;
            } else {
                int left = update(node.left, index, data);
                int right = update(node.right, index, data);

                node.data = left + right;
                return node.data;
            }
        }
        return node.data;
    }
}

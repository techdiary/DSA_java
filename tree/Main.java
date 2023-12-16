package tree;

public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] arr = {3,8, 6, 7, -2, -8, 4, 9};
        Segment stree = new Segment(arr);
//        stree.display();
        System.out.println(stree.query(1, 6));
//        for (int i = 0; i < 1000; i++) {
//            tree.insert(i);
//        }
//
//        System.out.println(tree.height());
    }
}

package trees.BST;

public class BSTpostorder {

    BSTnode root; // root of the BST

    BSTpostorder() { // constructor
        root = null; // initialize root to null
    }

    public void postorder() {
        postorderRec(root);
    }

    public void postorderRec(BSTnode root) {
        if (root != null) {
            postorderRec(root.left); // recursively go to the left
            postorderRec(root.right); // recursively go to the right
            System.out.print(root.data + " "); // print the data
        }
    }

    public static void main(String[] args) {
        BSTpostorder tree = new BSTpostorder();
        tree.root = new BSTnode(50);
        tree.root.left = new BSTnode(30);
        tree.root.right = new BSTnode(70);
        tree.root.left.left = new BSTnode(20);
        tree.root.left.right = new BSTnode(40);
        tree.root.right.left = new BSTnode(60);

        tree.postorder(); // 20 40 30 60 70 50
    }

}

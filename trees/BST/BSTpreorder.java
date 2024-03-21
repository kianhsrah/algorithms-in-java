package trees.BST;

public class BSTpreorder {

    BSTnode root; // root of the BST

    BSTpreorder() { // constructor
        root = null; // initialize root to null
    }

    public void preorder() {
        preorderRec(root);
    }

    public void preorderRec(BSTnode root) {
        if (root != null) {
            System.out.print(root.data + " "); // print the data
            preorderRec(root.left); // recursively go to the left
            preorderRec(root.right); // recursively go to the right
        }
    }

    public static void main(String[] args) {
        BSTpreorder tree = new BSTpreorder();
        tree.root = new BSTnode(50);
        tree.root.left = new BSTnode(30);
        tree.root.right = new BSTnode(70);
        tree.root.left.left = new BSTnode(20);
        tree.root.left.right = new BSTnode(40);
        tree.root.right.left = new BSTnode(60);

        tree.preorder(); // 50 30 20 40 70 60
    }

}

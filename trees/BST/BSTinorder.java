package trees.BST;

public class BSTinorder {
    BSTnode root; // root of the BST

    BSTinorder() { // constructor
        root = null; // initialize root to null
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(BSTnode root) {
        if (root != null) {
            inorderRec(root.left); // recursively go to the left
            System.out.print(root.data + " "); // print the data
            inorderRec(root.right); // recursively go to the right
        }
    }

    public static void main(String[] args) {
        BSTinorder tree = new BSTinorder();
        tree.root = new BSTnode(50);
        tree.root.left = new BSTnode(30);
        tree.root.right = new BSTnode(70);
        tree.root.left.left = new BSTnode(20);
        tree.root.left.right = new BSTnode(40);
        tree.root.right.left = new BSTnode(60);

        tree.inorder(); // 20 30 40 50 60 70
    }
}

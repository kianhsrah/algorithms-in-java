package trees.BST;

public class BSTimplementation {
    BSTnode root; // root of the BST

    BSTimplementation() { // constructor
        root = null; // initialize root to null
    }

    void insert(int data) { // insert a new node with data
        root = insertRec(root, data); // call the recursive insert function
    }

    BSTnode insertRec(BSTnode root, int data) {
        if (root == null) { // if the tree is empty, return a new node
            root = new BSTnode(data); // create a new node with data
            return root; // return the new node
        }

        if (data < root.data) { // if the data is less than the root's data, go left
            root.left = insertRec(root.left, data); // recursively insert the data to the left
        } else if (data > root.data) { // if the data is greater than the root's data, go right
            root.right = insertRec(root.right, data); // recursively insert the data to the right
        }

        return root; // return the root
    }

    int findSmallest() {
        return findSmallestRec(root);
    }

    int findSmallestRec(BSTnode root) {
        if (root.left == null) { // if the left child is null, the root is the smallest
            return root.data;
        } else {
            return findSmallestRec(root.left); // recursively find the smallest in the left subtree
        }
    }

    int findLargest() {
        return findLargestRec(root);
    }

    int findLargestRec(BSTnode root) {
        if (root.right == null) { // if the right child is null, the root is the largest
            return root.data;
        } else {
            return findLargestRec(root.right); // recursively find the largest in the right subtree
        }
    }

    public static void main(String[] args) {
        BSTimplementation tree = new BSTimplementation();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Smallest: " + tree.findSmallest()); // 20
        System.out.println("Largest: " + tree.findLargest()); // 80
    }
}

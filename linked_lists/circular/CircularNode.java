package linked_lists.circular;

public class CircularNode {

    int data; // data of the node
    CircularNode next; // pointer to the next node

    public CircularNode(int data) { // constructor
        this.data = data; // set the data
        this.next = null; // set the next pointer to null
    }
}

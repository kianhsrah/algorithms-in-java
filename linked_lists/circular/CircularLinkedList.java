package linked_lists.circular; // CircularLinkedList class is part of the linked_lists.circular package

public class CircularLinkedList {
    CircularNode head;

    // Constructor
    public CircularLinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            CircularNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to insert a new node at the end of the list
    public void insertAtEnd(int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            CircularNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Method to delete a node with given data from the list
    public void delete(int data) {
        if (head == null)
            return;

            CircularNode temp = head, prev = null;
        // If head is to be deleted
        if (temp != null && temp.data == data) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        } else {
            // Search for the node to be deleted, keep track of the previous node
            while (temp != null && temp.data != data) {
                prev = temp;
                temp = temp.next;
                if (temp == head)
                    break;
            }

            // If data was not found
            if (temp == head)
                return;

            // Unlink the node from the list
            prev.next = temp.next;
        }
    }

    // Method to update the data of a node at a given position
    public void update(int position, int newData) {
        CircularNode temp = head;
        if (temp == null)
            return;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
            if (temp == head)
                return; // Position not found, as it is a circular list
        }
        temp.data = newData;
    }

    // Method to traverse and display the elements of the circular linked list
    public void traverse() {
        if (head == null)
            return;

            CircularNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Insertion at the beginning
        list.insertAtBeginning(5);
        list.insertAtBeginning(10);
        list.insertAtBeginning(15);

        // Displaying the list
        System.out.println("Circular Linked List after insertion at beginning:");
        list.traverse(); // Output: 15 10 5

        // Insertion at the end
        list.insertAtEnd(20);
        list.insertAtEnd(25);

        // Displaying the list
        System.out.println("Circular Linked List after insertion at end:");
        list.traverse(); // Output: 15 10 5 20 25

        // Deleting a node
        list.delete(10);

        // Displaying the list after deletion
        System.out.println("Circular Linked List after deletion of node with data 10:");
        list.traverse(); // Output: 15 5 20 25

        // Updating a node
        list.update(2, 30); // Update node at position 2 with data 30

        // Displaying the list after update
        System.out.println("Circular Linked List after updating node at position 2 with data 30:");
        list.traverse(); // Output: 15 5 30 25
    }
    

}
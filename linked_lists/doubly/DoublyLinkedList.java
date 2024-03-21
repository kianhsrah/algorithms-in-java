package linked_lists.doubly;

public class DoublyLinkedList {
    DoublyNode head; // head of list

    public DoublyLinkedList() {
        this.head = null; // initialize head to null
    }

    public void insertAtStart(int data) {
        DoublyNode newNode = new DoublyNode(data); // create a new node
        newNode.next = head; // link the new node to the list
        newNode.prev = null; // since it is the first node, prev will be null

        if (head != null) { // if the list is not empty
            head.prev = newNode; // change the prev of head node to new node
        }

        head = newNode; // move the head to point to the new node
    }

    public void insertAtEnd(int data) {
        DoublyNode newNode = new DoublyNode(data); // create a new node
        DoublyNode temp = head; // set temp as head
        if (head == null) { // if the list is empty, make the new node as head
            head = newNode; // since it is the first node, prev will be null
            return; // return if the list is empty
        }
        while (temp.next != null) { // traverse till the last node
            temp = temp.next; // move the temp to the next node
        }
        temp.next = newNode; // link the new node after the last node
        newNode.prev = temp; // link the last node to the new node
    }

    public void insertAnywhere(int data, int position) {
        DoublyNode newNode = new DoublyNode(data); // create a new node
        DoublyNode temp = head; // set temp as head
        if (head == null) { // if the list is empty, make the new node as head
            head = newNode; // since it is the first node, prev will be null
            return; // return if the list is empty
        }
        for (int i = 0; i < position - 1; i++) { // traverse till the position
            temp = temp.next; // move the temp to the next node
        }
        newNode.next = temp.next; // link the new node to the next node
        temp.next = newNode; // link the temp to the new node
        newNode.prev = temp; // link the new node to the temp
        newNode.next.prev = newNode; // link the next node to the new node
    }

    public void delete(int position) { // delete a node at a given position
        DoublyNode temp = head; // set temp as head
        if (head == null) { // if the list is empty, return
            return; // return if the list is empty
        }
        if (position == 0) { // if the position is 0, delete the head node
            head = temp.next; // change the head
            return; // return if the position is 0
        }
        for (int i = 0; temp != null && i < position - 1; i++) { // traverse till the position
            temp = temp.next; // move the temp to the next node
        }
        if (temp == null || temp.next == null) { // if the position is more than the number of nodes
            return; // return if the position is more than the number of nodes
        }
        DoublyNode next = temp.next.next; // store the next of the next node
        temp.next = next; // unlink the next node
    }

    public void update(int data, int position) {
        DoublyNode temp = head; // set temp as head
        if (head == null) { // if the list is empty, return
            return; // return if the list is empty
        }
        for (int i = 0; i < position; i++) { // traverse till the position
            temp = temp.next; // move the temp to the next node
        }
        temp.data = data; // update the data of the node
    }

    public void traversal() {
        DoublyNode temp = head; // set temp as head
        while (temp != null) { // traverse till the last node
            System.out.print(temp.data + " "); // print the data of the node
            temp = temp.next; // move the temp to the next node
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtStart(10); // 10
        list.insertAtStart(20); // 20 10
        list.insertAtStart(30); // 30 20 10
        list.insertAtStart(40); // 40 30 20 10
        list.insertAtStart(50); // 50 40 30 20 10
        list.insertAtEnd(60); // 50 40 30 20 10 60
        list.insertAnywhere(70, 3); // 50 40 30 70 20 10 60
        list.delete(3); // 50 40 30 20 10 60
        list.delete(4); // 50 40 30 20 60
        list.update(80, 2); // 50 40 80 20 60
        list.traversal();
    }

}

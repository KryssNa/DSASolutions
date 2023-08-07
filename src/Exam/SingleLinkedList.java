package Exam;

public class SingleLinkedList {

    // Node class representing a singly linked list node
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

//    head node of the linked list set to null
    Node head = null;

    // Function to insert an element at the front of the linked list
    public void insertAtFront(int newData) {
        Node newNode = new Node(newData);

//        check if the linked list is empty
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Function to delete the last element of the linked list
    public void deleteLast() {
//        check if the linked list is empty
        if (head == null || head.next == null) {
            System.out.println("List is empty");
            return;
        }

//      move to the second last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    // Function to display the elements of the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.insertAtFront(1);
        list.insertAtFront(2);
        list.insertAtFront(3);
        list.insertAtFront(4);
        list.insertAtFront(5);

        list.display();

        list.deleteLast();
        list.deleteLast();

        list.display();
    }

}

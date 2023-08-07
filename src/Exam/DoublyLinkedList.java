package Exam;

public class DoublyLinkedList {

    // Node class representing a doubly linked list node
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    Node head = null;
    Node tail = null;

    // Function to add a node at the end of the doubly linked list
    void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
//            head null xa vane tail pani null huncha so head ra tail lai newNode ko value assign gareko
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Function to remove a specific node from the doubly linked list
    void removeNode(Node node) {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            head = tail = null;
        } else if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node current = head;
            while (current.next != node) {
                current = current.next;
            }
            current.next = current.next.next;
            current.next.prev = current;
            node.prev = null;
            node.next = null;
        }
    }

    // Function to remove a node with specific data from the doubly linked list
    void removeNode(int data) {
        if (head == null) {
            return;
        } else if (head == tail) {
            head = tail = null;
        } else if (head.data == data) {
            head = head.next;
            head.prev = null;
        } else if (tail.data == data) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node current = head;
            while (current.next.data != data) {
                current = current.next;
            }
            current.next = current.next.next;
            current.next.prev = current;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.addNode(60);
        list.addNode(70);
        list.removeNode(30);
        //list.removeNode(list.head);
        //list.removeNode(list.tail);
        //list.removeNode(list.head.next);
        Node current = list.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

package LinkedList.HW;

public class ImplementCircularQueueUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    void enqueue(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            head.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newnode;
            newnode.next = head;
        }
    }

    int dequeue() {
        if (head == null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int data = head.data;
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
            return data;
        }
    }

    int peek() {
        if (head == null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    void print() {
        Node current = head;
        while (current.next != head) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public static void main(String[] args) {
        ImplementCircularQueueUsingLinkedList queue = new ImplementCircularQueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Dequeue: "+queue.dequeue());
        System.out.println("Peek: "+queue.peek());
        queue.print();
    }
}
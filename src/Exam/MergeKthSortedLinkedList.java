package Exam;

public class MergeKthSortedLinkedList {

    // Node class representing a singly linked list node
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to append a new node at the end of a linked list
    static Node append(Node head, int newData) {
        if (head == null) {
            return new Node(newData);
        }

        Node newNode = new Node(newData);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    // Function to print the elements of a linked list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

//    you can use this function to merge two sorted linked lists into one sorted list
//    tala ko 2ta function lekhne

    // Function to merge two sorted linked lists into one sorted list
    static Node mergeList(Node p, Node q) {
        Node mergedHead;
        Node mergedTail;

        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }

        if (p.data <= q.data) {
            mergedHead = p;
            mergedTail = p;
            p = p.next;
        } else {
            mergedHead = q;
            mergedTail = q;
            q = q.next;
        }

        while (p != null && q != null) {
            if (p.data <= q.data) {
                mergedTail.next = p;
                mergedTail = mergedTail.next;
                p = p.next;
            } else {
                mergedTail.next = q;
                mergedTail = mergedTail.next;
                q = q.next;
            }
        }

        if (p == null) {
            mergedTail.next = q;
        } else {
            mergedTail.next = p;
        }

        return mergedHead;
    }

    // Function to merge all sorted linked lists in sorted order
    static Node mergeAllList(Node[] heads, int k)
    {
        if (k == 0) {
            return null;
        }

        while (k != 1) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                heads[i] = mergeList(heads[i], heads[j]);
                i++;
                j--;

                if (i >= j) {
                    k = j + 1;
                }
            }
        }

        return heads[0];
    }

    public static void main(String[] args) {
        int k = 3;
        Node[] heads = new Node[k];

        // Initialize all the lists to null
        for (int i = 0; i < k; i++) {
            heads[i] = null;
        }

        // Create the first linked list: 1 -> 5 -> 9
        heads[0] = append(heads[0], 1);
        heads[0] = append(heads[0], 5);
        heads[0] = append(heads[0], 9);

        // Create the second linked list: 2 -> 3 -> 7 -> 12
        heads[1] = append(heads[1], 2);
        heads[1] = append(heads[1], 3);
        heads[1] = append(heads[1], 7);
        heads[1] = append(heads[1], 12);

        // Create the third linked list: 8 -> 11 -> 13 -> 18
        heads[2] = append(heads[2], 8);
        heads[2] = append(heads[2], 11);
        heads[2] = append(heads[2], 13);
        heads[2] = append(heads[2], 18);

        // Merge all the sorted linked lists in sorted order
        Node finalList = mergeAllList(heads, k);

        // Print the final sorted list
        printList(finalList);
    }
}

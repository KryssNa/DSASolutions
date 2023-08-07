package LinkedList.HW;

//merge kth sorted linked list into one using linked list
public class mergeKthSortedLinkedList {

     class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Node result = null;
        for (int i = 0; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }

        return result;
    }

    private Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        mergeKthSortedLinkedList obj = new mergeKthSortedLinkedList();
        Node[] lists = new Node[4]; // dynamic allocation of size can be possible??

        lists[0] = obj.new Node(1);
        lists[0].next = obj.new Node(5);
        lists[0].next.next = obj.new Node(12);

        lists[1] = obj.new Node(1);
        lists[1].next = obj.new Node(3);
        lists[1].next.next = obj.new Node(9);

        lists[2] = obj.new Node(2);
        lists[2].next = obj.new Node(6);

        lists[3] = obj.new Node(4);
        lists[3].next = obj.new Node(5);
        lists[3].next.next = obj.new Node(8);

        Node result = obj.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}

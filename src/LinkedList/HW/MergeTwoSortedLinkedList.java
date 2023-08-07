package LinkedList.HW;

public class MergeTwoSortedLinkedList {

    //Merge Two Sorted Linked List In To One In Sorted Order

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    void insert(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
        }
        else{
            Node current=head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=newnode;
        }
    }

    void merge(MergeTwoSortedLinkedList l1,MergeTwoSortedLinkedList l2){

        Node current1=l1.head;
        Node current2=l2.head;
        while (current1!=null && current2!=null){
            if(current1.data<current2.data){
                insert(current1.data);
                current1=current1.next;
            }
            else{
                insert(current2.data);
                current2=current2.next;
            }
        }
        while (current1!=null){
            insert(current1.data);
            current1=current1.next;
        }
        while (current2!=null){
            insert(current2.data);
            current2=current2.next;
        }
    }
    void print(){
        Node current=head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    public static void main(String[] args) {
        MergeTwoSortedLinkedList list1=new MergeTwoSortedLinkedList();
        MergeTwoSortedLinkedList list2=new MergeTwoSortedLinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);
        list1.insert(7);
        list1.insert(9);
        System.out.println("list 1 data: ");
        list1.print();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);
        list2.insert(8);
        list2.insert(10);

        System.out.println("list 2 data: ");
        list2.print();
        MergeTwoSortedLinkedList mergeResult=new MergeTwoSortedLinkedList();
        mergeResult.merge(list1,list2);
        System.out.println("After merge: ");
        mergeResult.print();



    }
}

package LinkedList;

public class DoublyLinkedList {

    public static class Node{
      int data;
      Node next;
      Node prev;
      Node(int data){
          this.data=data;
          this.next=this.prev=null;
      }

    }

    Node head=null;
    Node tail=null;
    int size=0;
    void addNode(int data){
        size++;
        Node newnode=new Node(data);
        if(head==null){
          head=tail=newnode;
        }
        else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }

    }

    void removeNode(Node node){
        if(head==null){
            System.out.println("List is empty");
        }
        else if(head==tail){
            head=tail=null;
        }
        else if(node==head){
            head=head.next;
            head.prev=null;
        }
        else if(node==tail){
            tail=tail.prev;
            tail.next=null;
        }
        else{
            node.next.prev=node.prev;
            node.prev.next=node.next;
            node.next=node.prev=null;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list=new DoublyLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
//        list.removeNode();
//        list.removeNode(list.head);
//        list.removeNode(list.tail);
        System.out.println("data to be removed is: "+list.head.next.next.data);
        list.removeNode(list.head.next.next);
        Node current=list.head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }


}

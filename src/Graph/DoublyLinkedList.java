package Graph;

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
            Node current=head;
            while (current.next!=node){
                current=current.next;
            }
            current.next=current.next.next;
            current.next.prev=current;
            node.prev=null;
            node.next=null;
        }
    }

    void removeNode(int data){
        if(head==null){
            return;
        } else if (head==tail) {
            head=tail=null;
        } else if (head.data==data) {
            head=head.next;
            head.prev=null;
        } else if (tail.data==data) {
            tail=tail.prev;
            tail.next=null;
        }else {
            Node current =head;

            while (current.next.data!=data){
                current=current.next;
            }
            current.next=current.next.next;
            current.next.prev=current;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list=new DoublyLinkedList();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.addNode(60);
        list.addNode(70);
        list.removeNode(30);
//        list.removeNode(list.head);
//        list.removeNode(list.tail);
//        list.removeNode(list.head.next);
        Node current=list.head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }


}

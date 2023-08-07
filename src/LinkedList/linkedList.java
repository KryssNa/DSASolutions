package LinkedList;

public class linkedList {

    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public Node head=null;
    void insert(int data){
        Node newnode =new Node(data);

        if(head==null) {
            head=newnode;
        }else {
            Node current=head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=newnode;
        }
    }

    //insert using head and tail
    Node tail=null;
    void insert2(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
        }
        else{
            tail.next=newnode;
            tail=newnode;
        }

    }

    //print linked list
    void print(){
        Node current=head;
        while (current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    //insert at any position
    void insertAt(int data,int pos){
        Node newnode=new Node(data);
        if(pos==1){
            newnode.next=head;
            head=newnode;
        }
        else{
            Node current=head;
            for(int i=1;i<pos-1;i++){
                current=current.next;
            }
            newnode.next=current.next;
            current.next=newnode;
        }
    }

}

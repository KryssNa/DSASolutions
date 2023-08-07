package LinkedList.HW;

import LinkedList.linkedList;

public class LinkedListHW {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    //remove data at any position
    Node head=null;
    void removeAt(int pos){
        if(pos==1){
            head=head.next;
        }
        else{
            Node current=head;
            for(int i=1;i<pos-1;i++){
                current=current.next;
            }
            current.next=current.next.next;
        }
    }
    //remove node
    void remove(int data){
        if(head.data==data){
            head=head.next;
        }
        else{
            Node current=head;
            while (current.next.data!=data){
                current=current.next;
            }
            current.next=current.next.next;
        }
    }
    //insert afetr a node
    void insertAfter(int data,int after){
        Node newnode=new Node(data);
        Node current=head;
        while (current.data!=after){
            current=current.next;
        }
        newnode.next=current.next;
        current.next=newnode;
    }

    //insert before a node
    void insertBefore(int data,int before){
        Node newnode=new Node(data);
        Node current=head;
        while (current.next.data!=before){
            current=current.next;
        }
        newnode.next=current.next;
        current.next=newnode;
    }

    //remove after a node
    void removeAfter(int after){
        Node current=head;
        while (current.data!=after){
            current=current.next;
        }
        current.next=current.next.next;
    }
    //remove before a node
    void removeBefore(int before){
        Node current=head;
        while (current.next.next.data!=before){
            current=current.next;
        }
        current.next=current.next.next;
    }
}

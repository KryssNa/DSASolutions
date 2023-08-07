package LinkedList.HW;

public class ImplementQueueUsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    void enqueue(int data){
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
    int dequeue(){
        if(head==null){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int data=head.data;
            head=head.next;
            return data;
        }
    }
    int peek(){
        if(head==null){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            return head.data;
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
        ImplementQueueUsingLinkedList queue=new ImplementQueueUsingLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.print();
        System.out.println("Dequeue: "+queue.dequeue());
        System.out.println("Peek: "+queue.peek());
        queue.print();
    }
}

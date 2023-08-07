package HW;

public class ImplementQueueUsingTwoStacks {
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
        ImplementQueueUsingTwoStacks obj=new ImplementQueueUsingTwoStacks();
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.enqueue(40);
        obj.enqueue(50);
        obj.print();
        System.out.println("Dequeue element is: "+obj.dequeue());
        System.out.println("Peek element is: "+obj.peek());
        obj.print();
    }
}

package HW;

public class ImplementStackUsingTwoQueues {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    void push(int data){
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
    int pop(){
        if(head==null){
            System.out.println("Stack is empty");
            return -1;
        }
        else{
            Node current=head;
            while (current.next.next!=null){
                current=current.next;
            }
            int data=current.next.data;
            current.next=null;
            return data;
        }
    }
    int peek(){
        if(head==null){
            System.out.println("Stack is empty");
            return -1;
        }
        else{
            Node current=head;
            while (current.next!=null){
                current=current.next;
            }
            return current.data;
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
        ImplementStackUsingTwoQueues stack=new ImplementStackUsingTwoQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.print();
        System.out.println("Peek element is "+stack.peek());
        System.out.println("Pop element is "+stack.pop());
        System.out.println("Peek element is "+stack.peek());
        stack.print();
    }
}

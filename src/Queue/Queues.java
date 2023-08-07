package Queue;

public class Queues {
    int front=-1;
    int rear=-1;
    int size;
    int queue[];
    public Queues(int size){
        this.size=size;
        queue=new int[size];
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("queue overflow");
        }
        else{
            if(front==-1){
                front=0;
            }
            queue[++rear]=data;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("queue underflow");
                    return -999999;
        }
        if(front==rear){
            int temp=front;
            front=rear=-1;
            return queue[temp];
        }
        return queue[front++];
    }
    public boolean isFull(){
        return rear==size-1;
    }
    public boolean isEmpty(){
        return front==-1 && rear==-1;
    }


    public static void main(String [] args){
        Queues queue=new Queues(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("is queue empty: "+queue.dequeue());
        System.out.println(queue.dequeue());
    }

}

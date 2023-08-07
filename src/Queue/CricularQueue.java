package Queue;

public class CricularQueue {
    int front=-1;
    int rear=-1;
    int size;
    int queue[];
    CricularQueue(int size){
        
        this.size=size;
        queue=new int[size];
    }
    void enqueue(int data){
        if(isFUll()){
            System.out.println("queue overflow");
        }
        else{
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            queue[rear]=data;
        }
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("queue underflow");
            return -9999999;
        }
        if(front==rear){
            int temp=front;
            front=rear=-1;
            return  queue[temp];
        }
        int indxtemp=front;
        front=(front+1)%size;
        return queue[indxtemp];
    }
    boolean isFUll(){
        return (rear+1)%size==front;
    }
    boolean isEmpty(){
        return front==-1 && rear==-1;
    }
}


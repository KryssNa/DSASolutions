package Exam;

import Stacks.Stacks;

public class Qusing2Stk {
    Stacks s1=new Stacks(5);
    Stacks s2=new Stacks(5);
    void Enqueue(int data){
        if(s1.isFull()){
            System.out.println("Queue overflow cannot enqueue");
        }else{
            s1.push(data);
            System.out.println(data +"is enqueued into Queue");
        }
    }
    void Dequeqe(){
        if (s1.isEmpty()){
            System.out.println("Queue underflow");
            return;
        }
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int element =s2.pop();
        System.out.println(element +" is dequeued from Queue");
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public static void main(String[] args) {
        Qusing2Stk q=new Qusing2Stk();
        q.Enqueue(1);
        q.Enqueue(2);
        q.Enqueue(3);
        q.Enqueue(4);
        q.Enqueue(5);
        q.Enqueue(6);

        q.Dequeqe();
        q.Dequeqe();
        q.Dequeqe();
        q.Dequeqe();
        q.Dequeqe();
        q.Dequeqe();


    }
}

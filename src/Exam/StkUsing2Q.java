package Exam;

import Queue.Queues;

import java.util.LinkedList;

public class StkUsing2Q {

    Queues q1 =new Queues(5);
    Queues q2 =new Queues(5);
    void push(int data){
        if(q1.isEmpty()){
            q1.enqueue(data);
            System.out.println(data + " is pushed into the stack");
        }else if (q1.isFull()) {
            System.out.println("Cannot push \n stack overflow");
        }else{
            while(!q1.isEmpty()){
                q2.enqueue(q1.dequeue());
            }
            q1.enqueue(data);
            System.out.println(data + " is pushed into the stack");
            while (!q2.isEmpty()){
                q1.enqueue(q2.dequeue());
            }
        }
    }
    void pop(){
        if(q1.isEmpty()){
            System.out.println("Cannot pop \n stack underflow");
//            return -1;
        }else {
            int element =q1.dequeue();
            System.out.println(element +" is poped out of stack");
        }
    }

    public static void main(String[] args) {
        StkUsing2Q stk=new StkUsing2Q();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.push(6);
        stk.pop();
        stk.pop();
        stk.pop();
        stk.pop();
        stk.pop();
        stk.pop();
    }
}

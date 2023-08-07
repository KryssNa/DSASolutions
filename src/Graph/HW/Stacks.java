package Graph.HW;

public class Stacks {
    int stk[];
    int top=-1;
    public int size;
    public Stacks(int size){
        this.size=size;
        stk=new int[size];
    }

    public void push(int data){
        if(isFull()){
            System.out.println("stack overflow");
        }
        else{
//            top++;
//            stk[top]=data;
            stk[++top]=data;
        }

    }

    public int peek(){
        return stk[top];
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("stack underflow");
            return 'f';
        }
//        int temp=top;
//        top--;
//        return stk[temp];
        return stk[top--];
    }
    boolean isFull(){
        return top==size-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }
}

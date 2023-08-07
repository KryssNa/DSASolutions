package HW;

public class StackWithTwoQueues {
    private int[] queue1;
    private int[] queue2;
    private int top;

    public StackWithTwoQueues(int capacity) {
        queue1 = new int[capacity];
        queue2 = new int[capacity];
        top = -1;

    }

    public void push(int value) {
        queue1[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }

        while (top > 0) {
            queue2[++top - 1] = queue1[0];
            for (int i = 0; i < top - 1; i++) {
                queue1[i] = queue1[i + 1];
            }
        }

        int result = queue1[0];
        top--;

        int[] temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    public int peek() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }

        return queue1[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackWithTwoQueues stackWithTwoQueues=new StackWithTwoQueues(5);
//        stackWithTwoQueues.push(10);
        stackWithTwoQueues.peek();

    }
}

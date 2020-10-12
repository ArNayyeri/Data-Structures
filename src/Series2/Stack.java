package Series2;

public class Stack {
    private int top;
    private final int size = 100;
    private String[] items = new String[size];

    public Stack() {
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(String x) {
        if (isFull())
            System.out.println("Stack is Full!!!");
        else {
            items[++top] = x;
        }
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!");
            return null;
        } else {
            return items[top--];
        }
    }

}

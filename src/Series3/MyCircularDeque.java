package Series3;

public class MyCircularDeque<E> {
    private int front, rear, size;
    private Object[] items;

    public MyCircularDeque(int k) {
        size = k + 1;
        items = new Object[size];
        front = 0;
        rear = 0;
    }

    public boolean insertFront(E x) {
        if (isFull()) {
            System.out.println("Deque is Full!!!");
            return false;
        }
        front = (front + size - 1) % size;
        items[front] = x;
        return true;
    }

    public boolean insertLast(E x) {
        if (isFull()) {
            System.out.println("Deque is Full!!!");
            return false;
        }
        items[rear] = x;
        rear = (rear + 1) % size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is Empty!!!");
            return false;
        }
        front = (front + 1) % size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            System.out.println("Deque is Empty!!!");
            return false;
        }
        rear = (rear - 1 + size) % size;
        return true;
    }

    public E getFront() {
        if (isEmpty()) {
            System.out.println("Deque is Empty!!!");
            return null;
        }
        return (E) items[front];
    }

    public E getRear() {
        if (isEmpty()) {
            System.out.println("Deque is Empty!!!");
            return null;
        }
        return (E) items[(rear - 1 + size) % size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public int count() {
        return rear - front;
    }

    public int getSize() {
        return size - 1;
    }

    public boolean contain(E x) {
        for (int i = front; i != rear; i = (i + 1) % size) {
            if (items[i] == x)
                return true;
        }
        return false;
    }
}

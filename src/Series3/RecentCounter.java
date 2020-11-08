package Series3;

public class RecentCounter {
    MyCircularDeque<Integer> queue = new MyCircularDeque(1000);

    public void ResetCounter() {
        while (!queue.isEmpty())
            queue.deleteLast();
    }

    public int ping(int t) {
        MyCircularDeque<Integer> queue1 = new MyCircularDeque(1000);
        queue.insertLast(t);
        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.getFront() >= t - 3000 && queue.getFront() <= t)
                count++;
            queue1.insertLast(queue.getFront());
            queue.deleteFront();
        }
        queue = queue1;
        return count;
    }
}

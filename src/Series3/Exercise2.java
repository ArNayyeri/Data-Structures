package Series3;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println(getTime(2, new char[]{'A', 'A', 'A', 'B', 'B', 'B'}));
    }

    public static int getTime(int t, char[] tasks) {
        int x = 0;
        MyCircularDeque<Character>[] queues = new MyCircularDeque[2];
        queues[0] = new MyCircularDeque<>(tasks.length);
        queues[1] = new MyCircularDeque<>(tasks.length);
        for (char i : tasks)
            queues[0].insertLast(i);
        MyCircularDeque<Character> queue = new MyCircularDeque<>(t);
        int p;
        for (int i = 0; !queues[0].isEmpty() || !queues[1].isEmpty(); i = (i + 1) % 2) {
            p = queues[i].count();
            while (!queues[i].isEmpty()) {
                if (!queue.contain(queues[i].getFront())) {
                    if (queue.isFull()) {
                        queue.deleteFront();
                        x++;
                    }
                    queue.insertLast(queues[i].getFront());
                } else {
                    queues[(i + 1) % 2].insertLast(queues[i].getFront());
                }
                queues[i].deleteFront();
            }
            if (p == queues[(i + 1) % 2].count()) {
                if (queue.isFull()) {
                    queue.deleteFront();
                    x++;
                }
                queue.insertLast(' ');
            }
        }
        return x + queue.count();
    }
}

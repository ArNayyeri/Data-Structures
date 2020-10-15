package Series2;

public class Exercise5 {

    public static void main(String[] args) {
        Stack[] stack = new Stack[2];
        stack[0] = new Stack();
        stack[1] = new Stack();
        for (int i = 1; i <= 30; i++)
            stack[0].push(String.valueOf(i));
        print_function(stack);
    }

    public static void print_function(Stack[] stack) {
        for (int i = 0; !stack[i % 2].isEmpty() || !stack[(i + 1) % 2].isEmpty(); i++) {
            while (!stack[i % 2].isEmpty())
                stack[(i + 1) % 2].push(stack[i % 2].pop());
            for (int j = 0; j <= i && !stack[(i + 1) % 2].isEmpty(); j++)
                System.out.print(stack[(i + 1) % 2].pop() + " ");
            System.out.println();
        }
    }
}

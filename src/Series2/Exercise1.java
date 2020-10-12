package Series2;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(Infix_to_postfix("12 ^ 23 * 34 * 45 - ( ( 56 + 67 / 78 ) - 89 )"));
        System.out.println(Infix_to_postfix("a*b+c*d"));
        System.out.println(calculate_postfix("12 12 + 12 12 + *"));
    }

    public static String Infix_to_postfix(String x) {
        String y = "";
        Stack stack = new Stack();
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ' ')
                continue;
            do {
                if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                    int a = 0;
                    do {
                        a = a * 10 + Integer.parseInt(String.valueOf(x.charAt(i)));
                        i++;
                        if (i == x.length())
                            break;
                    } while (x.charAt(i) >= '0' && x.charAt(i) <= '9');
                    y += a + " ";
                    i--;
                    break;
                } else if (x.charAt(i) == '(') {
                    stack.push("(");
                    break;
                } else if (x.charAt(i) == ')') {
                    char a = stack.pop().charAt(0);
                    while (a != '(') {
                        y += a + " ";
                        a = stack.pop().charAt(0);
                    }
                    break;
                } else {
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf(x.charAt(i)));
                        break;
                    }
                    char a = stack.pop().charAt(0);
                    if (check_operators(a, x.charAt(i))) {
                        stack.push(String.valueOf(a));
                        stack.push(String.valueOf(x.charAt(i)));
                        break;
                    }
                    y += a + " ";
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf(x.charAt(i)));
                        break;
                    }
                }
            } while (!stack.isEmpty());
        }
        while (!stack.isEmpty())
            y += stack.pop() + " ";
        return y;
    }

    private static boolean check_operators(char a, char b) {
        int aa = -1, bb = -1;
        if (a == '^')
            aa = 2;
        else if (a == '*' || a == '/')
            aa = 1;
        else if (a == '+' || a == '-')
            aa = 0;
        if (b == '^')
            bb = 2;
        else if (b == '*' || b == '/')
            bb = 1;
        else if (b == '+' || b == '-')
            bb = 0;
        return aa < bb;
    }

    public static int calculate_postfix(String x) {
        Stack stack = new Stack();
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ' ')
                continue;
            if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                int a = 0;
                do {
                    a = a * 10 + Integer.parseInt(String.valueOf(x.charAt(i)));
                    i++;
                } while (x.charAt(i) >= '0' && x.charAt(i) <= '9');
                stack.push(String.valueOf(a));
                i--;
            } else {
                int p = Integer.parseInt(stack.pop().toString());
                int q = Integer.parseInt(stack.pop().toString());
                if (x.charAt(i) == '+')
                    p += q;
                else if (x.charAt(i) == '-')
                    p -= q;
                else if (x.charAt(i) == '*')
                    p *= q;
                else if (x.charAt(i) == '/')
                    p /= q;
                else if (x.charAt(i) == '^')
                    p = (int) Math.pow(p, q);
                stack.push(String.valueOf(p));
            }
        }
        return Integer.parseInt(stack.pop());
    }

}

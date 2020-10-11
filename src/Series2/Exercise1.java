package Series2;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(Infix_to_postfix("a^b*c*d-((e+f/g)-h)"));
        System.out.println(Infix_to_postfix("a*b+c*d"));
        System.out.println(calculate_postfix("11+11+*"));
    }

    public static String Infix_to_postfix(String x) {
        String y = "";
        Stack stack = new Stack();
        for (int i = 0; i < x.length(); i++) {
            do {
                if (x.charAt(i) >= 'a' && x.charAt(i) <= 'z') {
                    y += x.charAt(i);
                    break;
                } else if (x.charAt(i) == '(') {
                    stack.push('(');
                    break;
                } else if (x.charAt(i) == ')') {
                    char a = stack.pop();
                    while (a != '(') {
                        y += a;
                        a = stack.pop();
                    }
                    break;
                } else {
                    if (stack.isEmpty()) {
                        stack.push(x.charAt(i));
                        break;
                    }
                    char a = stack.pop();
                    if (check_operators(a, x.charAt(i))) {
                        stack.push(a);
                        stack.push(x.charAt(i));
                        break;
                    }
                    y += a;
                    if (stack.isEmpty()) {
                        stack.push(x.charAt(i));
                        break;
                    }
                }
            } while (!stack.isEmpty());
        }
        while (!stack.isEmpty())
            y += stack.pop();
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
            if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                stack.push(x.charAt(i));
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
                stack.push(String.valueOf(p).charAt(0));
            }
        }
        return Integer.parseInt(stack.pop().toString());
    }

}

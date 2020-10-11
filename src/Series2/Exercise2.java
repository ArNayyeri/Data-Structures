package Series2;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println(Infix_to_prefix("a^b*c*d-((e+f/g)-h)"));
    }

    public static String Infix_to_prefix(String x) {
        x = reverse(x);
        x = Exercise1.Infix_to_postfix(x);
        return reverse(x);
    }

    private static String reverse(String x) {
        String y = "";
        for (int i = x.length() - 1; i >= 0; i--) {
            if (x.charAt(i) == '(')
                y += ')';
            else if (x.charAt(i) == ')')
                y += '(';
            else
                y += x.charAt(i);
        }
        return y;
    }
    
}

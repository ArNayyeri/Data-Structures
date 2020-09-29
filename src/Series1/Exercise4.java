package Series1;

public class Exercise4 {
    public static void main(String[] args) {
        int x[][] = {{2, 3, 2}, {0, 2, 1}, {1, 0, 2}};
        print(transpose(x));
    }

    private static int[][] transpose(int x[][]) {
        int a[][] = new int[x.length][3];
        for (int i = 0; i < x.length; i++) {
            a[i][0] = x[i][1];
            a[i][1] = x[i][0];
            a[i][2] = x[i][2];
        }
        return sort(a);
    }

    private static int[][] sort(int x[][]) {
        for (int i = 1; i < x.length - 1; i++)
            for (int j = 1; j < x.length - i; j++)
                if ((x[j][0] > x[j + 1][0]) || (x[j][0] == x[j + 1][0] && x[j][1] > x[j + 1][1])) {
                    int t[] = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = t;
                }
        return x;
    }

    private static void print(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

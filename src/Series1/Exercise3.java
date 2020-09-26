package Series1;

import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args) {
        int a[][] = {{4, 4, 4}, {0, 0, 1}, {1, 1, 3}, {2, 3, 4}, {3, 3, 5}};
        int b[][] = {{4, 4, 4}, {0, 0, 7}, {0, 3, 1}, {3, 0, 1}, {3, 2, 3}};
        int c[][] = multiply(a, b);
        print(c);
    }

    private static int[][] multiply(int a[][], int b[][]) {
        int c[][] = new int[1][3];
        c[0][0] = a[0][0];
        c[0][1] = b[0][1];
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i][1] == b[j][0]) {
                    int ser = search(c, a[i][0], b[j][1]);
                    if (ser == -1) {
                        c = Arrays.copyOf(c, c.length + 1);
                        int x[] = new int[3];
                        x[0] = a[i][0];
                        x[1] = b[j][1];
                        x[2] = a[i][2] * b[j][2];
                        c[c.length - 1] = x;
                    } else {
                        c[ser][2] += a[i][2] * b[j][2];
                    }
                }
            }
        }
        c[0][2] = c.length - 1;
        return c;
    }

    private static int search(int a[][], int x, int y) {
        int b = -1;
        for (int i = 1; i < a.length; i++)
            if (a[i][0] == x && a[i][1] == y) {
                b = i;
                break;
            }
        return b;
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

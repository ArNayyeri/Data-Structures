package Series4;

public class Exercise2 {

    public static boolean isPalindrome(ListNode first) {
        int n = count(first);
        ListNode node;
        for (int i = 1; i <= n / 2; i++) {
            ListNode x = null;
            node = first;
            for (int j = 1; node != null; j++) {
                if (j == i) {
                    x = node;
                }
                if (j == n - i + 1) {
                    if (x.val != node.val)
                        return false;
                    break;
                }
                node = node.next;
            }
        }
        return true;
    }

    public static int count(ListNode first) {
        int n = 0;
        while (first != null) {
            first = first.next;
            n++;
        }
        return n;
    }
}

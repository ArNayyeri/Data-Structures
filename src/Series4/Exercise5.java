package Series4;

public class Exercise5 {

    public static ListNode sum(ListNode first1, ListNode first2) {
        ListNode firstResult = null;
        ListNode result = null;
        first1 = Exercise3.reverse(first1);
        first2 = Exercise3.reverse(first2);
        int x = 0;

        while (first1 != null && first2 != null) {
            if (firstResult == null) {
                firstResult = new ListNode();
                result = firstResult;
            } else {
                result.next = new ListNode();
                result = result.next;
            }

            result.val = first1.val + first2.val + x;

            if (result.val > 9) {
                result.val -= 10;
                x = 1;
            } else
                x = 0;

            first1 = first1.next;
            first2 = first2.next;
        }

        if (first1 != null) {
            do {
                result.next = new ListNode(first1.val + x);
                result = result.next;
                if (result.val > 9) {
                    result.val -= 10;
                    x = 1;
                } else
                    x = 0;
                first1 = first1.next;
            } while (first1 != null);
        } else if (first2 != null) {
            do {
                result.next = new ListNode(first2.val + x);
                result = result.next;
                if (result.val > 9) {
                    result.val -= 10;
                    x = 1;
                } else
                    x = 0;
                first2 = first2.next;
            } while (first2 != null);
        }

        if (x == 1) {
            result.next = new ListNode(x);
            result = result.next;
        }

        return Exercise3.reverse(firstResult);
    }
}

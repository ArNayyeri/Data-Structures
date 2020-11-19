package Series4;

public class Exercise4 {

    public static ListNode even_odd(ListNode first) {
        ListNode firstEven = null, firstOdd = null, even = null, odd = null;
        while (first != null) {
            if (first.val % 2 == 1) {
                if (firstEven == null) {
                    firstEven = first;
                }
                if (even != null)
                    even.next = first;
                even = first;
            } else {
                if (firstOdd == null) {
                    firstOdd = first;
                }
                if (odd != null)
                    odd.next = first;
                odd = first;
            }
            first = first.next;
        }
        if (odd != null)
            odd.next = null;
        if (firstEven == null) {
            return firstOdd;
        } else {
            even.next = firstOdd;
        }
        return firstEven;
    }
}

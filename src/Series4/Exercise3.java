package Series4;

public class Exercise3 {
    public static ListNode reverse(ListNode first) {
        ListNode back = null, node = first, next = null;
        while (node != null) {
            next = node.next;
            node.next = back;
            back = node;
            node = next;
        }
        return back;
    }
}

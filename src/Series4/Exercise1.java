package Series4;

public class Exercise1 {

    public static ListNode deleteElement(ListNode first, int v) {
        ListNode firstNode = first;
        ListNode node = first;
        ListNode backNode = null;
        while (node.next != null) {
            if (node.val == v) {
                if (firstNode == node)
                    firstNode = firstNode.next;
                if (backNode != null)
                    backNode.next = node.next;
            }
            backNode = node;
            node = node.next;
        }
        return firstNode;
    }
}

public class Leetcode86 {

    public static ListNode listSort(ListNode head, int x) {
        ListNode dummyNode1 = new ListNode(0);
        ListNode dummyNode2 = new ListNode(0);
        ListNode node1 = dummyNode1;
        ListNode node2 = dummyNode2;

        while(head != null) {
            if(head.val < x) {
                node1.next = head;
                node1 = node1.next;
            } else {
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }

        node1.next = dummyNode2.next;
        node2.next = null;

        return dummyNode1.next;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2, node);
        ListNode node2 = new ListNode(3, node1);

        listSort(node2, 2);
    }
}

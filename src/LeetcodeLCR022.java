public class LeetcodeLCR022 {



    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                fast = head;

                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }

                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2, node);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(4,node2);
        ListNode node4 = new ListNode(5,node3);
        node.next = node2;

        System.out.println(detectCycle(node4).val);
    }
}

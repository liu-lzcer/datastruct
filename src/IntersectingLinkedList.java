public class IntersectingLinkedList {

    static ListNode getLoop(ListNode head) {
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
    static ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2) {
        if(loop1 == loop2) {
            ListNode save = loop1.next; //因为loop1 == loop2 所以只用保存其中一个即可
            loop1.next = null;

            ListNode result = Leetcode160.getIntersectionNode(head1,head2);

            loop1.next = save;

            return result;

        } else {
            ListNode cur = loop1.next;
            while(cur != loop1) {
                if(cur == loop2)
                    return loop1;
                cur = cur.next;
            }
            return null;
        }

    }

    ListNode getIntersectingLinkedList(ListNode head1, ListNode head2) {
        ListNode loop1 = getLoop(head1);
        ListNode loop2 = getLoop(head2);

        if(loop1 == null && loop2 == null) {
            return Leetcode160.getIntersectionNode(head1, head2);
        } else if(loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }

        return null;
    }

    public static void main(String[] args) {
// 创建链表 head1: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3 (节点3是环的入口)
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        ListNode node6 = new ListNode(6, node5);
        node1.next = node3; // 形成环
        ListNode head1 = node6;

// 创建链表 head2: 7 -> 8 -> 6 -> 3 (节点6是相交节点)
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8, node7);
        node7.next = node6; // 节点8指向节点6，形成相交
        ListNode head2 = node8;

// 调用方法
        ListNode result = new IntersectingLinkedList().getIntersectingLinkedList(head1, head2);
        System.out.println(result != null ? result.val : "null"); // 预期输出: 3 或 6
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode random;
    ListNode(int x) {
        val = x;
        next = null;
        random = null;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }
    ListNode(int val, ListNode next, ListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
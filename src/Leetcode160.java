public class Leetcode160 {

//    public class ListNode{
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;

        while(node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;

//        ListNode node1 = headA;
//        ListNode node2 = headB;
//
//        int i = 0, j = 0;
//
//        while (node1.next != null) {
//            node1 = node1.next;
//            i++;
//        }
//
//        while (node2.next != null) {
//            node2 = node2.next;
//            j++;
//        }
//
//        node1 = headA;
//        node2 = headB;
//
//        if (i < j) {
//            for (int k = j - i; k > 0; k--) {
//                node2 = node2.next;
//            }
//        } else {
//            for (int k = i - j; k > 0; k--) {
//                node1 = node1.next;
//            }
//        }
//
//        while (node1 != node2) {
//            node1 = node1.next;
//            node2 = node2.next;
//        }
//
//        return node1;

    }


    public static void main(String[] args) {

    }
}

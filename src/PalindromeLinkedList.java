import java.util.Scanner;

public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    void reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
    }
    //判断是否回文
    boolean IsPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while(fast.next != null) {
            fast = fast.next;
        }

        reverse(slow);

        while(head != null && fast != null) {
            if(head.val != fast.val) {
                return false;
            }
            head = head.next;
            fast = fast.next;
        }

        return true;
    }


    public static void main(String[] args) {
        PalindromeLinkedList ps = new PalindromeLinkedList();
        
        ListNode node3 = new ListNode(3);         // 第三个节点
        ListNode node2 = new ListNode(2, node3);  // 第二个节点，next 指向 node3
        ListNode node1 = new ListNode(3, node2);  // 第一个节点，next 指向 node2
        System.out.println(ps.IsPalindrome(node1));
    }
}

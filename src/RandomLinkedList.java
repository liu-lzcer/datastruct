import java.util.HashMap;
import java.util.Map;

public class RandomLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2, node);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(4, node2);
        ListNode node4 = new ListNode(5, node3);

        Method1 m1 = new Method1();
        ListNode head = m1.method1(node4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        Method2 m2 = new Method2();
        head =  m2.method2(node4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
class Method1 {
/*
* 通过map进行关系映射
* 再利用map进行复制操作
*/

    ListNode method1(ListNode head) {
        Map<ListNode,ListNode> map = new HashMap<>();

        ListNode cur = head;

        while(cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }

        return map.get(head);
    }

}
class Method2 {
/*
* 通过链表创建位置对应关系，通过人为地创造规律来解题
* 通过相似来创造规律
*/

    ListNode method2(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            cur.next = new ListNode(cur.val, cur.next);
            cur = cur.next.next;
        }
        cur = head.next;
        while (cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return head.next;
    }

}
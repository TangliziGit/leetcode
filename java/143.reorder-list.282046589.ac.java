/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void reorderList(ListNode head) {
        if (null == head || null == head.next) return;
        ListNode p1 = head, p2 = head.next;
        while (null != p2 && null != p2.next) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode head2 = p1.next;
        p1.next = null;
        p2 = head2.next;
        head2.next = null;
        while (null != p2) {
            p1 = p2.next;
            p2.next = head2;
            head2 = p2;
            p2 = p1;
        }

        p1 = head; p2 = head2;
        while (null != p1) {
            ListNode t = p1.next;
            p1 = p1.next = p2;
            p2 = t;
        }
    }
}

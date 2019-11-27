/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode a = head.next, b = head.next.next;
        while (true) {
            if (a == null || b == null || b.next == null) return null;
            if (a == b) {
                a = head;
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }
                return a;
            }
            
            a = a.next;
            b = b.next.next;
        }
    }
}

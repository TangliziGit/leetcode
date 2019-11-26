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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode a = head.next, b = head.next.next;
        while (true) {
            if (a == null) return false;
            if (b == null || b.next == null) return false;
            if (a == b) return true;
            a = a.next;
            b = b.next.next;
        }
    }
}

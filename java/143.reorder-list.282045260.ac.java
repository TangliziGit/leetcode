/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private int length = -1;
    
    public void reorderList(ListNode head) {
        ListNode tail = getTailNode(null, head, 0);
        ListNode x = head, y = tail;
        while (x != null && y != null) {
            ListNode nx = x.next, ny = y.next;
            x.next = y;
            y.next = nx;
            if (null == nx) y.next=ny;
            x = nx; y = ny;
        }
    }
    
    private ListNode getTailNode(ListNode prev, ListNode x, int len) {
        if (null == x) {
            this.length = len;
            return null;
        }
        
        ListNode tail = getTailNode(x, x.next, len + 1);
        if (null == tail) tail = x;
        if (len == length / 2) x.next = null;
        if (len == length / 2 - 1) x.next = null;
        if (len > length / 2) x.next = prev;
        return tail;
    }
}

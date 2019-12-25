/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode((val==0)?0:1);
        h.next = head;
        
        ListNode x = h;
        while (null != x) {
            while (null != x.next && x.next.val == val)
                x.next = x.next.next;
            x = x.next;
        }
        
        return h.next;
    }
}

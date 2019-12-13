/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (null == head) return head;
        
        ListNode nh = new ListNode(0);
        nh.next = head;
        ListNode x = head;
        while (x.next != null) {
            if (x.val > x.next.val)
                insert(nh, x.next, x);
            else x = x.next;
        }
        return nh.next;
    }
    
    private void insert(ListNode x, ListNode tar, ListNode last) {
        ListNode next = tar.next;
        while (x != last) {
            if (x.next.val >= tar.val) {
                tar.next = x.next;
                x.next = tar;
                break;
            }
            x = x.next;
        }
        last.next = next;
    }
}

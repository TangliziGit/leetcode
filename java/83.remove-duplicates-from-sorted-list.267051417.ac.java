/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans=head;
        while (head != null){
            if (head.next !=null && head.val == head.next.val) head.next=head.next.next;
            else head=head.next;
        }return ans;
    }
}

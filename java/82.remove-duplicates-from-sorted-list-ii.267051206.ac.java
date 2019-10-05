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
        ListNode ans=new ListNode(0);
        ans.next=head; head=ans;
        while (head != null){
            if (head.next != null && head.next.next != null && head.next.next.val == head.next.val){
                int next=head.next.val;
                while (head.next.next!=null && head.next.next.val == next) head.next.next=head.next.next.next;
                head.next=head.next.next;
            }
            else head=head.next;
        }return ans.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode ans = new ListNode(0);
        ListNode sptr=ans;
        ans.next = head;
        head = ans;
        
        while (head != null && head.next != null){
            if (head.next.val < x){
                ListNode next=head.next;
                head.next=head.next.next;
                if (head == sptr) head=next;
                
                next.next=sptr.next;
                sptr.next=next;
                sptr=sptr.next;
            }else head=head.next;
        }
        return ans.next;
    }
}

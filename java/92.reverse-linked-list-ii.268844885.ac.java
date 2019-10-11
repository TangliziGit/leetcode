/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
Tricks:
1. make a fake head
2. store the previous node before the nodes need operate
2. make robust after AC samples
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode ans=new ListNode(0);
        ans.next=head;
        ListNode pre=ans;
        for (int i=0; i<m-1; i++) pre=pre.next;
        
        ListNode ptr=pre.next.next, prev=pre.next, tmp;
        for (int i=0; i<n-m; i++){
            tmp=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=tmp;
        }
        pre.next.next=ptr;
        pre.next=prev;
        
        return ans.next;
    }
}

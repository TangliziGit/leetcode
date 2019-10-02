/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null, tail=null, prev=null;
        int tmp=0;
        while (l1!=null || l2!=null || tmp!=0){
            int val=(tmp+ 
                 ((l1!=null)?l1.val:0) + 
                 ((l2!=null)?l2.val:0) );
            tail=new ListNode(val%10);
            tmp=val/10;
            
            if (prev==null) head=tail;
            if (prev!=null) prev.next=tail;
            prev=tail;
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
        }
        
        return head;
    }
    
}

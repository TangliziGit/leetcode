/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return null;
        int length=getListLength(head);
        k=length-(k+1)%length;
        
        ListNode tail=head;
        while (tail.next!=null) tail=tail.next;
        tail.next=head;
        
        ListNode node=head, res=null;
        while (k --> 0) node=node.next;
        res=node.next;
        node.next=null;
        
        return res;
    }
    
    private int getListLength(ListNode node){
        int res=0;
        while (node!=null) {res++; node=node.next;}
        return res;
    }
}

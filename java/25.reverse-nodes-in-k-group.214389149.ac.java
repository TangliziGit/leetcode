/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */
class Solution {
    private int K;
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==0 || k==1) return head;
        
        this.K=k;
        return solve(head);
    }
    
    private ListNode solve(ListNode head){
        ListNode[] bottoms=hook(head, K);
        // print(bottoms[0], bottoms[1]);
        if (bottoms[0]!=null){
            head.next=solve(bottoms[1]);
            return bottoms[0];
        }return head;
    }
    
    private ListNode[] hook(ListNode pre, int rest){
        if (pre==null) return new ListNode[]{null, null};
        if (rest==1) return new ListNode[]{null, pre.next};
        // if (rest==2 && pre.next==null) return 
        ListNode node=pre.next;
        ListNode[] bottoms=hook(node, rest-1);
        
        if (bottoms[0]!=null || (rest==2 && node!=null))
            node.next=pre;
        if (rest==2)// && node!=null)
            bottoms[0]=node;
        
        return bottoms;
    }
    
    private static void print(Object...obj){
        System.out.println(Arrays.deepToString(obj));
    }
}


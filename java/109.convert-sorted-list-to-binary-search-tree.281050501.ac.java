/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) return null;
        this.head = head;
        return build(0, getSize(head)-1);
    }
    
    private Integer getSize(ListNode x) {
        int cnt = 0;
        while (x != null) {
            cnt++;
            x = x.next;
        }
        return cnt;
    }
    
    private TreeNode build(int start, int end) {
        if (end - start < 0) return null;
        
        int mid = (start + end) / 2;
        TreeNode left = build(start, mid-1); 
        TreeNode x = new TreeNode(head.val);
        head = head.next;
        x.left = left;
        x.right = build(mid+1, end);
        return x;
    }
}

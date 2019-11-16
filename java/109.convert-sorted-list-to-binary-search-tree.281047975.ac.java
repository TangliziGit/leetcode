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
    
    private List<Integer> nodes;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) return null; 
        this.nodes = new ArrayList<>();
        
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
        
        return build(0, nodes.size()-1);
    }
    
    private TreeNode build(int start, int end) {
        if (end - start == 0) return new TreeNode(nodes.get(start));
        if (end - start == 1) {
            TreeNode n1 = new TreeNode(nodes.get(start));
            TreeNode n2 = new TreeNode(nodes.get(end));
            n2.left = n1;
            return n2;
        }
        int mid = (start + end) / 2;
        TreeNode x = new TreeNode(nodes.get(mid));
        x.left = build(start, mid-1);
        x.right = build(mid+1, end);
        return x;
    }
}

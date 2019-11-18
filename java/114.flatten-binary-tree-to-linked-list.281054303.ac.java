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
    
    private TreeNode head, xs;
    
    public void flatten(TreeNode root) {
        if (null == root) return;
        this.head = new TreeNode(root.val);
        this.xs = head;
        travel(root);
        root.right = head.right.right;
        root.left = null;
    }
    
    private void travel(TreeNode x) {
        if (null == x) return;
        xs.right = new TreeNode(x.val);
        xs = xs.right;
        travel(x.left);
        travel(x.right);
    }
}

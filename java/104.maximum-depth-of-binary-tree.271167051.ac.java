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
    public int maxDepth(TreeNode x) {
        if (x==null) return 0;
        return Math.max(maxDepth(x.left), maxDepth(x.right))+1;
    }
}

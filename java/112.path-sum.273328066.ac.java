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
    public boolean hasPathSum(TreeNode x, int sum) {
        if (x == null) return false;
        if (x.val == sum && x.left == null && x.right == null)
            return true;
        
        return hasPathSum(x.left, sum-x.val) || hasPathSum(x.right, sum-x.val);
    }
}

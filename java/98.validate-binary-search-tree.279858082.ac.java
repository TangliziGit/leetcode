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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode x, Long low, Long high){
        if (x == null) return true;
        if (x.val<=low || x.val>=high) return false;
        return isValid(x.left, low, (long)x.val) && isValid(x.right, (long)x.val, high);
    }
}

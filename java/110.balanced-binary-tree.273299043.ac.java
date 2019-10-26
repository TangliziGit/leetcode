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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    public int height(TreeNode x){
        if (x == null) return 0;
        
        int left = height(x.left);
        int right = height(x.right);
        if (left == -1 || right == -1 || Math.abs(left-right)>1)
            return -1;
        return Math.max(left, right)+1;
    }
}

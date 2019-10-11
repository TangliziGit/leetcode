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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root != null) solve(ans, root);
        return ans;
    }
    
    private void solve(List<Integer> list, TreeNode root){
        if (root.left!=null) solve(list, root.left);
        list.add(root.val);
        if (root.right!=null) solve(list, root.right);
    }
}

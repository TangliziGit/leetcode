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
    public int sumNumbers(TreeNode root) {
        if (null == root) return 0;
        return solve(root, new LinkedList<Integer>());
    }
    
    private int solve(TreeNode x, LinkedList<Integer> path) {
        int ans = 0;
        if (null == x.left && null == x.right) {
            for (Integer n: path) ans = 10*ans + n;
            ans = 10*ans + x.val;
        } else {
            path.offer(x.val);
            if (null != x.left) ans += solve(x.left, path);
            if (null != x.right) ans += solve(x.right, path);
            path.removeLast();
        }
        return ans;
    }
}

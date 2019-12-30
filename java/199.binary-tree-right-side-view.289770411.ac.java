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
    public List<Integer> rightSideView(TreeNode root) {
        if (null == root) return new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        
        que.offer(root);
        que.offer(null);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            
            if (null != node.left) que.offer(node.left);
            if (null != node.right) que.offer(node.right);
            if (null == que.peek()) {
                que.poll();
                ans.add(node.val);
                if (!que.isEmpty()) que.offer(null);
            }
        }
        
        return ans;
    }
}

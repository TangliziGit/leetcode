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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new LinkedList<>();
        
        LinkedList<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        ans.add(list);
        que.offer(root);
        
        int[] cnt = new int[]{1, 0};
        int level = 0;
        while (!que.isEmpty()){
            TreeNode x = que.poll();
            
            list.add(x.val);
            if (x.left != null){
                que.offer(x.left);
                cnt[1-level]++;
            }
            if (x.right != null){
                que.offer(x.right);
                cnt[1-level]++;
            }
            
            if (--cnt[level] == 0){
                level=1-level;
                list = new LinkedList<>();
                ans.add(list);
            }
        }
        
        ans.removeLast();
        Collections.reverse(ans);
        return ans;
    }
}

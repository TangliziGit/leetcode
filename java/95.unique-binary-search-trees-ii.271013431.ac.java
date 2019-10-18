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
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new LinkedList<>();
        return solve(1, n);
    }
    
    private List<TreeNode> solve(int x, int y){
        if (x>y) return new LinkedList<TreeNode>(){{add(null);}};
        
        List<TreeNode> ans = new LinkedList<>();
        for (int i=x; i<=y; i++){
            List<TreeNode> leftList=solve(x, i-1);
            List<TreeNode> rightList=solve(i+1, y);
            
            for (TreeNode left: leftList)
                for (TreeNode right: rightList){
                    TreeNode root = new TreeNode(i);
                    ans.add(root);
                    root.left=left;
                    root.right=right;
                }
        }
        return ans;
    }
}

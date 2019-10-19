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
    private int[] pre, in;
    private Map<Integer, Integer> idx = new HashMap<>();
    private int i;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre = preorder;
        this.in = inorder;
        this.i = 0;
        
        for (int i=0; i<in.length; i++)
            idx.put(in[i], i);
        return build(0, pre.length);
    }
    
    private TreeNode build(int l, int r){
        if (i == in.length || l>r) return null;
        TreeNode x = new TreeNode(pre[i++]);
        int left = idx.get(pre[i-1])-1, right = idx.get(pre[i-1])+1;
        x.left=build(l, left);
        x.right=build(right, r);
        return x;
    }
}

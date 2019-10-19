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
    private int[] in, pos;
    private Map<Integer, Integer> idx = new HashMap<>();
    private int i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.in = inorder;
        this.pos = postorder;
        this.i = pos.length-1;
        
        for (int i=0; i<in.length; i++)
            idx.put(in[i], i);
        return build(0, pos.length-1);
    }
    
    private TreeNode build(int l, int r){
        if (i == -1 || l>r) return null;
        TreeNode x = new TreeNode(pos[i--]);
        int left = idx.get(pos[i+1])-1, right = idx.get(pos[i+1])+1;
        x.right = build(right, r);
        x.left = build(l, left);
        return x;
    }
}

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
    private int[] xs;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.xs = nums;
        return build(0, nums.length-1);
    }
    
    private TreeNode build(int l, int r){
        if (l>r) return null;
        int mid = (l+r)/2;
        TreeNode x = new TreeNode(xs[mid]);
        x.left = build(l, mid-1);
        x.right = build(mid+1, r);
        return x;
    }
}

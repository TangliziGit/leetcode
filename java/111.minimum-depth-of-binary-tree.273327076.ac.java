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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Item> que = new LinkedList<>();
        que.offer(new Item(root, 0));
        
        while (!que.isEmpty()){
            Item x = que.poll();
            TreeNode n = x.node;
            
            if (n.left == null && n.right == null)
                return x.depth+1;
                
            if (n.left != null) que.offer(new Item(n.left, x.depth+1));
            if (n.right != null) que.offer(new Item(n.right, x.depth+1));
        }
        return 0;
    }
    
    class Item{
        TreeNode node;
        int depth;
        Item(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}

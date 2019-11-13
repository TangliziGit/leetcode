/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<NodeMix> que = new LinkedList<>();
        que.add(new NodeMix(root, 1));
        
        int limit = 1;
        Node prev = null;
        while (!que.isEmpty()) {
            NodeMix xx = que.poll();
            Node x = xx.node;
            
            if (xx.id == limit){
                limit *= 2;
                prev = x.left;
                if (prev != null) {
                    prev.next = x.right;
                    prev = prev.next;
                }
            } else if (prev != null) {
                prev.next = x.left;
                prev = prev.next;
                prev.next = x.right;
                prev = prev.next;
            }
            
            if (x.left!=null) que.add(new NodeMix(x.left, xx.id*2));
            if (x.right!=null) que.add(new NodeMix(x.right, xx.id*2+1));
        }
        return root;
    }
    
    class NodeMix {
        public Node node;
        public int id;
        
        NodeMix(Node node, int id) {
            this.node = node;
            this.id = id;
        }
    }
}

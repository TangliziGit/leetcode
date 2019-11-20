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
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        que.offer(null);
        
        Node prev = null;
        while (!que.isEmpty()) {
            Node n = que.poll();
            
            if (null == prev)
                prev = n;
            else if (null != prev){
                prev.next = n;
                prev = n;
            }
            
            if (null == n) {
                if (null != que.peek()) que.offer(null);
                continue;
            }
            if (null != n.left) que.offer(n.left);
            if (null != n.right) que.offer(n.right);
        }
        return root;
    }
}

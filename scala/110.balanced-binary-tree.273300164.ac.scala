/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def isBalanced(root: TreeNode): Boolean = height(root) != -1
    
    def height(x: TreeNode): Int = x match {
        case null => 0
        case x => (height(x.left), height(x.right)) match {
            case (l, r) if l == -1 || r == -1 || Math.abs(l - r) > 1
                => -1
            case (l ,r)
                => l.max(r) + 1
        }
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = (p, q) match {
        case (null, null) => true
        case (null, _) => false
        case (_, null) => false
        case (x, y) => x.value == y.value && isSameTree(x.left, y.left) && isSameTree(x.right, y.right)
    }
}

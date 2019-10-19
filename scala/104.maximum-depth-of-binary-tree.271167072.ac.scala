/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def maxDepth(root: TreeNode): Int = root match {
        case null => 0
        case x => maxDepth(x.left).max(maxDepth(x.right))+1
    }
}

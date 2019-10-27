/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def hasPathSum(root: TreeNode, sum: Int): Boolean = root match {
        case null => false
        case x if x.value == sum && x.left == null && x.right == null =>
            true
        case x =>
            hasPathSum(x.left, sum-x.value) || hasPathSum(x.right, sum-x.value);
    }
}

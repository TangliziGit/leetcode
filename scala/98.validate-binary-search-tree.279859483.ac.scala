/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def isValidBST(root: TreeNode): Boolean = isValid(root, Long.MinValue, Long.MaxValue)
    
    def isValid(x: TreeNode, low: Long, high: Long): Boolean = {
        if (x == null) true
        else if (x.value <= low || x.value >= high) false
        else isValid(x.left, low, x.value) && isValid(x.right, x.value, high)
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
        if (root != null && root.left == null && root.right == null && sum == root.value)
            List(List(root.value))
        else if (root != null && root.left == null && root.right == null && sum != root.value)
            List()
        else if (root == null) List()
        else {
            val left = pathSum(root.left, sum - root.value)
            val right = pathSum(root.right, sum - root.value)
            (left ::: right).map(root.value :: _)
        }
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def pathSum(root: TreeNode, sum: Int): List[List[Int]] = root match {
        case null => List()
        case x if x.left == null && x.right == null && sum != x.value =>
            List()
        case x if x.left == null && x.right == null && sum == x.value =>
            List(List(root.value))
        case x => {
            val left = pathSum(x.left, sum - x.value)
            val right = pathSum(x.right, sum - x.value)
            (left ::: right).map(x.value :: _)
        }
    }
}

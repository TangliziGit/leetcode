/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
// an elegant solution
object Solution {
    def sumNumbers(root: TreeNode): Int = solve(root, Nil)
    
    def solve(n: TreeNode, xs: List[Int]): Int = n match {
        case null => 0
        // case TreeNode(x) => (xs:::List(x)).reduce(10*_ + _) // TreeNode is not a case class
        case n if null == n.left && null == n.right => (xs:::List(n.value)).reduce(10*_ + _)
        case n => solve(n.left, xs:::List(n.value)) + solve(n.right, xs:::List(n.value))
    }
}

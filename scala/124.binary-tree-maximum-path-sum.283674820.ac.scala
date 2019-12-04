/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def maxPathSum(root: TreeNode): Int = {
        def solve(x: TreeNode): (Long, Long) = x match {
            case null => (Int.MinValue, Int.MinValue)
            case x => {
                val (left, lmax) = solve(x.left)
                val (right, rmax) = solve(x.right)
                val res = x.value.toLong
                            .max(left + x.value.toLong)
                            .max(right + x.value.toLong)
            
                (res.max(0L), res.max(left + x.value.toLong + right).max(lmax).max(rmax))
            }
        }
        
        solve(root)._2.toInt
    }
}

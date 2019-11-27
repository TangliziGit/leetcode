/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def preorderTraversal(root: TreeNode): List[Int] = {
        def travel(sta: List[TreeNode], ans: List[Int]): List[Int] = sta match {
            case x :: xs => {
                var _ans = x.value :: ans
                (x.left, x.right) match {
                    case (null, null) => travel(xs, _ans)
                    case (null, _) => travel(x.right :: xs, _ans)
                    case (_, null) => travel(x.left  :: xs, _ans)
                    case (_, _) => travel(x.left :: x.right :: xs, _ans)
                }
            }
            case _ => ans.reverse
        }
        
        root match {
            case null => Nil
            case _ => travel(root :: Nil, Nil)
        }
    }
}

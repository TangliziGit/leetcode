object Solution {
  def inorderTraversal(root: TreeNode): List[Int] = {
    def solve(list: List[Int], root: TreeNode): Unit = {
      if (root.left!=null) solve(list, root.left);
      list = list ++ root.val
      if (root.right!=null) solve(list, root.right);
    }

    var ans = Array[int]();
    if (root != null) solve(ans, root);
    ans
  }
}
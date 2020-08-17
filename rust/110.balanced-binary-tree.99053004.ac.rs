// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
use std::cmp::max;

impl Solution {
    pub fn is_balanced(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        dfs(&root).1
    }
}

// node -> (height, isBalanced)
fn dfs(node: &Option<Rc<RefCell<TreeNode>>>) -> (i32, bool) {
    match node {
        None => (0, true),
        Some(node) => {
            let (l_height, l_b) = dfs(&node.borrow().left);
            let (r_height, r_b) = dfs(&node.borrow().right);

            if (!l_b || !r_b) || (l_height - r_height).abs() > 1 {
                (0, false)
            } else {
                (1+max(l_height, r_height), true)
            }
        }
    }
}

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

impl Solution {
    pub fn invert_tree(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        helper(&root);
        root
    }
}

fn clone(node: &Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
    // can not move out `match *node`.
    match node {
        None => None,
        Some(node) => Some(Rc::clone(&node)),
    }
}

fn helper(node: &Option<Rc<RefCell<TreeNode>>>) {
    match node {
        None => (),
        Some(node) => {
            // node: Rc
            helper(&node.borrow().left);
            helper(&node.borrow().right);

            let left = clone(&(*node).borrow().left);
            let right = clone(&(*node).borrow().right);

            let mut node = (*node).borrow_mut();
            node.left = right;
            node.right = left;
        }
    }

}

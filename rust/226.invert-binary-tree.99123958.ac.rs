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

fn helper(node: &Option<Rc<RefCell<TreeNode>>>) {
    match node {
        None => (),
        Some(node) => {
            helper(&node.borrow().left);
            helper(&node.borrow().right);

            let left = (*node).borrow()         // &TreeNode
                    .left                       // &TreeNode -> 自动解引用暂时获得TreeNode.left（是否获得所有权？） 
                    .as_ref()                   // TreeNode.left -> 自动引用得 &Option<Rc> -> Option<&Rc<...>>
                    .map(|x| Rc::clone(x));     // Option<Rc<...>>
            
            let right = (*node).borrow().right
                    .as_ref()
                    .map(|x| Rc::clone(x));

            let mut node = (*node).borrow_mut();
            node.left = right;
            node.right = left;
        }
    }

}

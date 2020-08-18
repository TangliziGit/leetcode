// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
//
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
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
    pub fn sorted_list_to_bst(head: Option<Box<ListNode>>) -> Option<Rc<RefCell<TreeNode>>> {
        let mut nodes = Vec::new();
        let mut head = &head;

        while let Some(node) = head.as_ref() {
            nodes.push(node.val);
            head = &node.next;
        }

        build(&nodes)
    }
}

fn build(nodes: &[i32]) -> Option<Rc<RefCell<TreeNode>>> {
    if nodes.len() >= 1 {
        let mid = nodes.len() / 2;
        Some(Rc::new(RefCell::new(TreeNode {
            val: nodes[mid],
            left: build(&nodes[..mid]),
            right: build(&nodes[mid+1..])
        })))
    } else {
        None
    }
}

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
    pub fn sorted_list_to_bst(mut head: Option<Box<ListNode>>) -> Option<Rc<RefCell<TreeNode>>> {
        let length = len(&head);
        build(&head, 0, length).0
    }
}

fn len(mut head: &Option<Box<ListNode>>) -> usize {
    let mut size = 0;

    while let Some(node) = head.as_ref() {
        head = &node.next;
        size += 1;
    }

    size
 }

// 如何改变一个`&mut`的指向？
fn build(mut head: &Option<Box<ListNode>>, start: usize, end: usize) -> (Option<Rc<RefCell<TreeNode>>>, &Option<Box<ListNode>>) {
    if start + 1 > end {
        (None, head)
    } else if start + 1 == end {
        let node = head.as_ref().unwrap();
        let res = Some(Rc::new(RefCell::new(TreeNode{
            val: node.val,
            left: None,
            right: None
        })));

        (res, &node.next)
    } else {
        let mid = (end + start) / 2;
        let (left, head) = build(&head, start, mid);

        let node = head.as_ref().unwrap();
        let (next, val) = (&node.next, node.val);
        let (right, head) = build(&node.next, mid+1, end);

        (
            Some(Rc::new(RefCell::new(TreeNode { val, left, right }))),
            head
        )
    }
}

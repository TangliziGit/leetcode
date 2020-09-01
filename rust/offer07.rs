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
use std::collections::HashMap;

impl Solution {
    pub fn build_tree(preorder: Vec<i32>, inorder: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        let pos = inorder.iter()
            .enumerate()
            .fold(HashMap::new(), |mut map, (i, x)| {       // ! mut
                map.insert(*x, i as i32);                   // ! x: &T, i: usize
                map
            });
        
        build(0, (pos.len()-1) as i32, &pos, &mut preorder.into_iter())
    }
}

fn build<I>(left: i32, right: i32, pos: &HashMap<i32, i32>, pre: &mut I) -> Option<Rc<RefCell<TreeNode>>> 
where                                           // ! Iterator need be mut
    I: Iterator<Item=i32>                       // ! IntoIterator have not `next` method
{
    if left > right {
        return None;
    }

    let val = pre.next().unwrap();
    let cur = pos.get(&val).unwrap();              // ! borrow here

    let left = build(left, cur-1, pos, pre);
    let right = build(cur+1, right, pos, pre);

    Some(Rc::new(RefCell::new(TreeNode {
        val, left, right
    })))
}

// 多注意变量要不要mut和borrow

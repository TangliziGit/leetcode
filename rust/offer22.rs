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
impl Solution {
    pub fn get_kth_from_end(head: Option<Box<ListNode>>, k: i32) -> Option<Box<ListNode>> {
        fn len(head: &Option<Box<ListNode>>) -> i32 {
            match head {
                None => 0,
                Some(item) => len(&item.next) + 1
            }
        }

        let k = len(&head) - k;
        helper(head, k)
    }
}

fn helper(head: Option<Box<ListNode>>, k: i32) -> Option<Box<ListNode>> {
    match head {
        None => None,
        Some(item) => {
            if k == 0 {
                Some(item)
            } else {
                helper(item.next, k-1)
            }
        }
    }
}


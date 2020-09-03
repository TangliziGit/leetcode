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
    pub fn delete_node(head: Option<Box<ListNode>>, val: i32) -> Option<Box<ListNode>> {
        let mut ans = Some(Box::new(ListNode { 
            val: 0, 
            next: head,
        }));

        let mut head = &mut ans;

        while let Some(ref mut item) = head {
            if let Some(ref mut next) = item.next {
                if next.val == val {                // ! cannot move out of `next.next` which is behind a mutable reference
                    item.next = next.next.take();
                }
            } 

            head = &mut item.next;
        }

        ans.unwrap().next
    }
}

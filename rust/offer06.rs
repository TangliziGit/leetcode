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
    pub fn reverse_print(head: Option<Box<ListNode>>) -> Vec<i32> {
        let mut sta = Vec::new();
        let mut head = &head;

        while let Some(item) = head {       // 亦可匹配借用
            sta.push(item.val);
            head = &item.next;
        }

        sta.into_iter()                     // iter 只承载借用
            .rev()
            .collect()
    }
}

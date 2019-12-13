/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode slower = head, faster = head;
        
        while (faster != null && faster.next != null) {
            if (null == (faster = faster.next.next)) break;
            slower = slower.next;
        }
        
        ListNode secondHead = slower.next;
        slower.next = null;
        
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(secondHead);
        ListNode ans = new ListNode(0), list = ans;
        
        while (null != list1 && null != list2) {
            if (list1.val < list2.val) {
                list.next = list1;
                list1 = list1.next;
            } else {
                list.next = list2;
                list2 = list2.next;
            }
            list = list.next;
        }
        
        if (null != list1) list.next = list1;
        if (null != list2) list.next = list2;
        
        return ans.next;
    }
    
    private void debug(ListNode x) {
        while (x!=null) {
            System.out.print(x.val + "->");
            x = x.next;
        }System.out.println("");
    }
}

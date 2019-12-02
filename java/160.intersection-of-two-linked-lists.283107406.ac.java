/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// version 2. concat two list for same length
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if (null == headA || null == headB) return null;
//         ListNode a = headA, b = headB;
//         boolean ac = false, bc = false;
//         while (a != null) {
//             if (a == b) return a;
//             a = a.next;
//             b = b.next;
//             if (!ac && null == a) {a = headB; ac = true;}
//             if (!bc && null == b) {b = headA; bc = true;}
//         }
//         return null;
//     }
// }

// version 1. fill element to shorter one, and O(n) scan for same reference.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA), lenB = getLen(headB);
        
        if (lenA < lenB) return ans(headB, headA, lenB, lenA);
        return ans(headA, headB, lenA, lenB);
    }

    private ListNode ans(ListNode headA, ListNode headB, int lenA, int lenB) {
        headB = fill(headB, lenA-lenB);
        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }return null;
    }
    
    private int getLen(ListNode x) {
        int len = 0;
        while (x != null) {
            len++;
            x = x.next;
        }return len;
    }
    
    private ListNode fill(ListNode x, int len) {
        while (len --> 0) {
            ListNode xx = new ListNode(0);
            xx.next = x;
            x = xx;
        }return x;
    }
}

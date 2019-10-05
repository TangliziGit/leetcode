/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def deleteDuplicates(head: ListNode): ListNode = {
        val ans: ListNode = head
        var ptr: ListNode = head
        while (ptr != null) ptr match{
            case h if h.next != null && h.next.x == h.x => h.next=h.next.next
            case _ => ptr = ptr.next
        }
        ans
    }
}

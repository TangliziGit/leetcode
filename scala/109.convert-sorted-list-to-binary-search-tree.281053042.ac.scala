/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def sortedListToBST(_head: ListNode): TreeNode = {
        var head = _head
        def getSize(nx: ListNode): Int = {
            var cnt: Int = 0
            var x = nx
            while (x != null) {
                cnt += 1
                x = x.next
            }
            cnt
        }
        
        def build(start: Int, end: Int): TreeNode = (start, end) match {
            case (x, y) if y - x < 0 =>
                null
            case (x, y) => {
                var mid: Int = (x + y) / 2
                val left = build(x, mid-1)
                val n = TreeNode(head.x)
                head = head.next
                n.left = left
                n.right = build(mid+1, end)
                n
            }
        }
        
        if (null == head) null
        else build(0, getSize(head)-1)
    }
    
}

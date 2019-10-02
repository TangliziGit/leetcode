// N=sum(n1, ..., nk)
// 1. O(Nlogk):
//      priority_queue<Pair>, Pair is <val, idx>.
//      we search the min value of queue, then get it and replace it with it's link list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode(-1);
        ListNode tmp=head;
        PriorityQueue<Pair> que=new PriorityQueue();
        
        for (int i=0; i<lists.length; i++) if (lists[i]!=null){
            que.offer(new Pair(lists[i].val, i));
            lists[i]=lists[i].next;
        }
        
        while (!que.isEmpty()){
            Pair p=que.poll();
            tmp.next=new ListNode(p.val);
            tmp=tmp.next;
            
            if (lists[p.idx]!=null){
                que.offer(new Pair(lists[p.idx].val, p.idx));
                lists[p.idx]=lists[p.idx].next;
            }
        }return head.next;
    }
    
    static class Pair implements Comparable<Pair>{
        final int val, idx;
        public Pair(int val, int idx){
            this.val=val; this.idx=idx;
        }
        
        public int compareTo(Pair a){
            return val-a.val;
        }
    }
}

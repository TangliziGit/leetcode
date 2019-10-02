/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> ans=new LinkedList();
        intervals.sort((a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            return b.end-a.end;
        });

        for (Interval cur: intervals){
            Interval last=null;
            
            if (!ans.isEmpty())
                last=ans.getLast();

            if (last!=null && last.end>=cur.start){
                ans.removeLast();
                ans.offerLast(new Interval(
                    Math.min(last.start, cur.start),
                    Math.max(last.end, cur.end)
                ));
            }else
                ans.offerLast(cur);
        }return ans;
    }
}


// 脑子有问题，本题复杂度下界为O(n)，别想着二分了
/**
 * Definition for an interval.
 * public class int[] {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval){
        if (intervals.length==0){
            /*int[][] result=new int[1][];
            result[0]=newInterval;
            return result;*/
            return new int[][]{newInterval};
        }else if (intervals[intervals.length-1][1]<newInterval[0]){
            int[][] list=new int[intervals.length+1][];
            int size=0;
            for (int[] interval: intervals)
                list[size++]=interval;
            list[size++]=newInterval;
            return list;
        }else if (intervals[0][0]>newInterval[1]){
            int[][] list=new int[intervals.length+1][];
            int size=0;
            list[size++]=newInterval;
            for (int[] interval: intervals)
                list[size++]=interval;
            return list;
        }
        
        int firstIndex=binarySearchForFirstItem(intervals, newInterval);
        int lastIndex =binarySearchForLastItem(intervals, newInterval);
        
        System.out.println(firstIndex);
        System.out.println(lastIndex);

        newInterval[0] =Math.min(intervals[firstIndex][0], newInterval[0]);
        newInterval[1] =Math.max(intervals[lastIndex][1], newInterval[1]);

        int[][] result=new int[intervals.length-(lastIndex-firstIndex+1)+1][];
        int size=0;
        for (int i=0; i<firstIndex; i++)
            result[size++]=intervals[i];
        result[size++]=newInterval;
        for (int i=lastIndex+1; i<intervals.length; i++)
            result[size++]=intervals[i];

        return result;
    }

    public int binarySearchForLastItem(int[][] intervals, int[] newInterval){
        int l=0, r=intervals.length;

        while (l<r){
            int mid=(r+l)/2;
            if (intervalContains(intervals[mid] , newInterval[1] ))
                return mid;
            if (intervals[mid] [1]  < newInterval[1] ) l=mid+1;
            else if (intervals[mid] [0]  > newInterval[1] ) r=mid-1;
        }

        for (int i=Math.min(r+5, intervals.length-1); i>=Math.max(l-5, 0); i--)
            if (intervalContains(intervals[i], newInterval[1]))
                return i;
            else if (intervals[i][1]  < newInterval[1] )
                return i;
        return intervals.length-1;
    }

    public int binarySearchForFirstItem(int[][] intervals, int[] newInterval){
        int l=0, r=intervals.length;

        while (l<r){
            int mid=(r+l)/2;
            if (intervalContains(intervals[mid] , newInterval[0] ))
                return mid;
            if (intervals[mid] [1]  > newInterval[0] ) r=mid-1;
            else if (intervals[mid] [0]  < newInterval[0] ) l=mid+1;
        }

        for (int i=Math.max(l-5, 0); i<Math.min(r+5, intervals.length); i++)
            if (intervalContains(intervals[i], newInterval[0]))
                return i;
            else if (intervals[i][0] > newInterval[0] )
                return i;
        
        return 0;
    }

    private boolean intervalContains(int[] interval, int elem){
        return interval[0] <=elem && interval[1] >=elem;
    }
}


class Solution {
    public int divide(int dividend, int divisor) {
        int sign=-1;
        if ((dividend>0 && divisor>0) || (dividend<0 && divisor<0))
            sign=1;
        long res=sign*solve(Math.abs((long)dividend), Math.abs((long)divisor));
        if (res>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (res<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)res;
    }
    
    private long solve(long num, long x){
        if (num<x) return 0;
        long res=1, sum=x;
        while (num>sum+sum){
            sum+=sum;
            res+=res;
        }
        return res+solve(num-sum, x);
    }
}

class Solution {
    public int reverse(int x) {
        if (x<0) return -1*solve(-1*x);
        return solve(x);
    }
    
    private int solve(int x){
        long res=0;
        while (x!=0){
            res=res*10+x%10;
            x/=10;
        }
        if (res<-(long)1<<31 || res>=(long)1<<31) return 0;
        return (int)res;
    }
}


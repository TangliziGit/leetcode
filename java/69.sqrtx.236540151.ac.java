class Solution {
    public int mySqrt(int x) {
        float res=1, tmp=1;
        do{
            tmp=res;
            res=(res+x/res)/2;
        }while(Math.abs(res-tmp)>=0.5);
        
        int ret=(int)res;
        if (ret*ret>x) return ret-1;
        return ret;
    }
}

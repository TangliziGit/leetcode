// version 2
class Solution{
    public double myPow(double x, long n){
        if (n==0 || x==1) return 1;
        if (x==-1) return 1-2*(n%2);
        if (n*Math.log10(x)<-10) return 0;
        if (n*Math.log(x)>1024*Math.log(2))
            return Double.POSITIVE_INFINITY;
        if (n<0){x=1/x; n=-n;}
        double ans=1;
        for (long i=0; (1<<i)<=n; i++){
            if (((1<<i)&n)!=0)
                ans*=x;
            x*=x;
        }
        return ans;
    }
}

// version 1
// TLE
// Because BigDecimal is too slow, we can only use double to handle this question.
// import java.math.BigDecimal;

// class Solution {
//     public double myPow(double x, long n) {
//         if (n==0) return 1;
//         return solve(x, n).doubleValue();
//     }

//     private BigDecimal solve(double x, long n){
//         if (n<0){
//             x=1/x; n=-n;
//         }
//         BigDecimal ans=new BigDecimal(1);
//         BigDecimal tmp=new BigDecimal(x);
//         for (long i=0; (1<<i)<=n; i++){
//             if (((1<<i)&n)!=0)
//                 ans=ans.multiply(tmp);
//             tmp=tmp.multiply(tmp);
//         }
//         return ans;
//     }
// }


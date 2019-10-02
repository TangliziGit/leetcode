import java.math.BigInteger;

class Solution {
    public int uniquePaths(int m, int n) {
        BigInteger ans=BigInteger.valueOf(1);
        
        m--; n--;
        if (m<n){
            m=m+n;
            n=m-n;
            m=m-n;
        }
        for (int i=m+1; i<=n+m; i++)
            ans=ans.multiply(BigInteger.valueOf(i));
        for (int i=1; i<=n; i++)
            ans=ans.divide(BigInteger.valueOf(i));
        
        return ans.intValue();
    }
}

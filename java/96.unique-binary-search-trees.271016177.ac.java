import java.math.BigInteger;

class Solution {
    public int numTrees(int n) {
        int ans=1;
        for (int i=1; i<=n; i++)
            ans = (int)((long)ans*(4*i-2)/(i+1));
        return ans;
    }
}

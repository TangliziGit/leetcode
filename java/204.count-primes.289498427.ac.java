import java.math.BigInteger;

// consider the Lehmer's formula
class Solution {
    public int countPrimes(int n) {
        boolean[] map = new boolean[n];
        int cnt = 0;
        
        for (int i = 2; i<n; i++) if (!map[i]) {
            for (int j = 2; j*i<n; j++) map[j*i] = true;
            cnt++;
        }
        
        return cnt;
    }
}

// the answer is common binary prefix.
// m = x x x x 0 y y y y
// n = x x x x 1 z z z z
// let i = m -> n, then i will become
// i'= x x x x 1 0 0 0 0

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int ans = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ans <<= 1;
        }
        return ans * n;
    }
}

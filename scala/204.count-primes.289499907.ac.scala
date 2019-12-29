object Solution {
    def countPrimes(n: Int): Int = {
        var map = Array.ofDim[Boolean](n)
        var cnt = 0
        
        for (i <- 2 until n if !map(i)) {
            for (j <- 1 to n/i+1 if j*i<n) map(j*i) = true
            cnt += 1
        }
        
        cnt
    }
}

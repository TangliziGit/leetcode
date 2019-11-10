object Solution {
    def isInterleave(s1: String, s2: String, s3: String): Boolean = {
        if (s1.length + s2.length != s3.length) false
        else {
            var dp = new Array[Boolean](s1.length+5)

            dp(0) = true
            for (j <- 1 to s3.length)
                for (i <- (0 to j.min(s1.length)).reverse){
                    var tmp: Boolean = false
                    if (i!=j && j-i-1<s2.length && s2(j-i-1) == s3(j-1))
                        tmp |= dp(i)
                    if (i-1>=0 && s1(i-1) == s3(j-1))
                        tmp |= dp(i-1)
                    dp(i) = tmp
                }
            dp(s1.length)
        }
    }
}

object Solution {
    private var _dp: Array[Array[Int]] = null
    private var xs, ys: String = null
    
    def minDistance(word1: String, word2: String): Int = {
        xs=word1; ys=word2
        _dp=Array.tabulate[Int](word1.length, word2.length)((x, y) => -1)
        dp(word1.length-1, word2.length-1)
    }
    
    def dp(i: Int, j: Int): Int = (i, j) match {
        case (-1, -1) => 0
        case (i, j) if (i == -1) => j+1
        case (i, j) if (j == -1) => i+1
        case (i, j) if (i < -1 || j < -1) => Int.MaxValue-1
        case (i, j) if (_dp(i)(j) != -1) => _dp(i)(j)
        case _ => {
            _dp(i)(j) = (dp(i, j-1)+1)
                .min(dp(i-1, j)+1)
                .min(dp(i-1, j-1)+{if (xs(i)==ys(j)) 0 else 1})
            _dp(i)(j)
        }
    }
}

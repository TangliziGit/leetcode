import scala.collection.mutable.ListBuffer

object Solution {
    def partition(s: String): List[List[String]] = {
        var n: Int = s.length
        var seg = Array.ofDim[Boolean](n, n)
        var ans = ListBuffer[List[String]]()
        
        def solve(path: ListBuffer[String] = ListBuffer[String](), pos: Int = 0): Unit = {
            if (pos == n) {
                ans += path.toList
            } else for (i <- pos until n if seg(pos)(i)) {
                path += s.substring(pos, i+1)
                solve(path, i+1)
                path.remove(path.size - 1)
            }
        }
        
        for (y <- 0 until n; x <- (0 to y).reverse)
            seg(x)(y) = (s(x) == s(y)) && (x+1>=y-1 || seg(x+1)(y-1))
            
        solve()
        ans.toList
    }
    
}


object Solution {
    def minimumTotal(tri: List[List[Int]]): Int = {
        var dp = Array.ofDim[Int](tri.size, tri.size);
        var vis = Array.ofDim[Boolean](tri.size, tri.size);
        
        def solve(x: Int, y: Int): Int = {
            if (y == tri.size) 0
            else if (vis(y)(x)) dp(y)(x)
            else {
                vis(y)(x) = true
                dp(y)(x) = solve(x, y+1).min(solve(x+1, y+1)) + tri(y)(x)
                dp(y)(x)
            }
        }
        solve(0, 0)
    }
}

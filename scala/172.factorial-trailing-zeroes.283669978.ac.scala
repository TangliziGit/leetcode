object Solution {
    def trailingZeroes(n: Int): Int = {
        @annotation.tailrec
        def solve(x: Int, ans: Int): Int = x match {
            case 0 => ans
            case x => solve(x/5, x/5+ans)
        }
        
        solve(n, 0)
    }
}

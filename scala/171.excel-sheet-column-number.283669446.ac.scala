object Solution {
    def titleToNumber(s: String): Int = {
        @annotation.tailrec
        def solve(xs: List[Char], ans: Int): Int = xs match {
            case Nil => ans
            case x :: xs => solve(xs, x-'A'+1 + 26*ans)
        } 
        
        solve(s.toList, 0)
    }
}

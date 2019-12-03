object Solution {
    def convertToTitle(n: Int): String = {
        @annotation.tailrec
        def solve(x: Int, ans: List[Char]): List[Char] = x match {
            case x if x <= 26 => ('A' + x.toChar - 1).toChar +: ans
            case x => solve((x-1) / 26, ('A' + ((x-1)%26).toChar).toChar +: ans)
        }
        
        solve(n, Nil).mkString
    }
}

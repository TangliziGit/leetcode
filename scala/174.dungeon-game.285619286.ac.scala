object Solution {
    def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
        if (null == dungeon || dungeon.size == 0 || dungeon.head.size == 0)
            return 0
        
        val width = dungeon.head.size
        val height = dungeon.size
        var dp: Array[Array[Int]] = Array.fill[Int](height, width)(-1)
        
        def solve(x: Int, y: Int): Int = {
            if (x<0 || y<0 || x>=width || y>=height)
                Int.MaxValue/2
            else if (x==width-1 && y==height-1)
                (-dungeon.last.last + 1).max(1)
            else if (-1 != dp(y)(x))
                dp(y)(x)
            else {
                dp(y)(x) = (solve(x+1, y) - dungeon(y)(x)).max(1)
                    .min((solve(x, y+1) - dungeon(y)(x)).max(1))
                dp(y)(x)
            }
        }
        
        solve(0, 0)
    }
}

object Solution {
    def isHappy(n: Int): Boolean = {
        def next(n: Int): Int = 
            n.toString.map(x => (x - '0')*(x - '0')).sum
        
        var vis = Set(n)
        var x = n
        while ((x = next(x))!=1 && !vis.contains(x))
            vis = vis + x;
        x == 1
    }
}

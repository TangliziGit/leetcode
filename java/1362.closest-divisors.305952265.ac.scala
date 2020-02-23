object Solution {
    def closestDivisors(num: Int): Array[Int] = {
        
        def getDivisors(num: Int): (Int, Int) = {
            var ans: (Int, Int) = (0, 0)
            for (i <- (0 to Math.sqrt(num).toInt).reverse if (ans._1 == 0) && (num % i == 0)) 
                if (num % (num / i) == 0) ans = (i, num / i)
            ans
        }
        
        var a = getDivisors(num + 1)
        var b = getDivisors(num + 2)
        
        if (Math.abs(a._2 - a._1) > Math.abs(b._2 - b._1))
            Array(b._2, b._1)
        else
            Array(a._2, a._1)
    }
    
}

object Solution {
    def maxProfit(prices: Array[Int]): Int = {
        if (prices == null || prices.length == 0) 0
        else prices.zip( prices.scan(Int.MaxValue)(math.min).tail ).map(x => x._1 - x._2).foldLeft(0)(math.max)
    }
}

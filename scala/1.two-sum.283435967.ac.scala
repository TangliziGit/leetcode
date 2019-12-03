object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var map: Map[Int, Int] = Map()
        
        for (i <- 0 until nums.length) map += (nums(i) -> i)
        
        // for-loop return a Unit
        for (i <- 0 until nums.length if map.contains(target - nums(i)) && i != map(target - nums(i)))
            return Array(i, map(target - nums(i))) // map.get(x) -> Option[Int]
        Nil.toArray
    }
}

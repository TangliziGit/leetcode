object Solution {
    def twoSum(nums: Array[Int], t: Int): Array[Int] = {
        val zipped = nums.zipWithIndex
        val map = zipped.toMap
        
        zipped
            .filter(x => map.contains(t - x._1))
            .filter(x => x._2 != map(t - x._1))
            .take(1)
            .flatMap(x => List(map(t - x._1), x._2))
            .toArray
    }
}

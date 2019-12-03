object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val zipped = (nums zip nums.indices)
        val map = zipped.toMap
        
        zipped
            .filter(x => map.contains(target - x._1))
            .filter(x => x._2 != map(target - x._1))
            .take(1)
            .flatMap(x => List(map(target - x._1), x._2))
            .toArray
    }
}

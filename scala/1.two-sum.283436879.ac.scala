object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val map = (nums zip nums.indices).toMap
        
        for (i <- nums.indices if map.contains(target - nums(i)))
            if (i != map(target - nums(i)))
                return Array(i, map(target - nums(i)))
        Nil.toArray
    }
}

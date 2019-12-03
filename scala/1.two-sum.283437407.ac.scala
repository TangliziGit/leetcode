object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val map = (nums zip nums.indices).toMap
        
        for (i <- nums.indices) (i, map.get(target - nums(i))) match {
            case (x, Some(y)) if x != y => 
                return Array(i, map(target - nums(i)))
            case _ => None
        }
        Nil.toArray
    }
}

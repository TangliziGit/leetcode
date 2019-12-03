object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        nums.groupBy(x => x)
            .mapValues(x => x.length)
            .filter(x => x._2 > nums.length/2)
            .head._1
    }
}

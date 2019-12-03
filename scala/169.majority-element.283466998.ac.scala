object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        nums.foldLeft((0, 0)){
            case ((0, _), x) => (1, x)
            case ((cnt, x), y) if x == y => (cnt+1, x)
            case ((cnt, x), y) => (cnt-1, x)
        }._2
    }
}

// Note:
// 1. `to` means enclose, `until` means last one excluded.
// 2. implicit varibles need to be annotation as `implicit val(/var)`.
object Solution {
    def rob(nums: Array[Int]): Int = {
        if (nums.length == 0) return 0
        if (nums.length == 1) return nums(0)
        
        def solve(start: Int, n: Int)(implicit nums: Array[Int]): Int = {
            var ans, first, second = 0

            for (i <- start to n reverse) {
                ans = first.max(second+nums(i))
                second = first
                first = ans
            }
            ans
        }
        
        implicit val xs = nums
        0.max(solve(1, xs.length-2))
            .max(solve(0, xs.length-2))
            .max(solve(1, xs.length-1))
    }
}

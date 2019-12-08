object Solution {
    def rob(nums: Array[Int]): Int = {
        var dp = Array.fill(nums.length){-1}
        def solve(x: Int): Int = x match {
            case x if x < 0 => 0
            case x if dp(x) >= 0 => dp(x)
            case x => {
                dp(x) = solve(x-1) max solve(x-2) + nums(x)
                dp(x)
            }
        }
        
        solve(nums.length-1) max solve(nums.length-2)
    }
}

object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        var cnt, major = 0
        for (x <- nums) {
            if (cnt == 0) major = x
            
            if (major == x) cnt += 1
            else cnt -=1
        }
        major
    }
}

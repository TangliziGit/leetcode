object Solution {
    def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
        var l: Int = 0
        var r: Int = numbers.length - 1
        
        while (numbers(l) + numbers(r) != target)
            if (numbers(l) + numbers(r) > target) r-=1
            else l+=1
        Array(l+1, r+1)
    }
}

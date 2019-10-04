object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        val cnt = for (i <- Array(0, 1, 2)) yield nums.count(_ == i)
        var idx = for (i <- Array(0, 1, 2)) yield cnt.take(i).sum
        def kind(i: Int): Int = i match {
            case i if i < cnt(0) => 0
            case i if i < cnt(0)+cnt(1) => 1
            case _ => 2
        }
        
        for (i <- 0 until nums.length)
            while (nums(i)!=kind(i)){
                val tmp: Int=nums(i)
                val ij: Int=idx(nums(i))
                nums(i)=nums(ij)
                nums(ij)=tmp;
                
                idx(tmp)=idx(tmp)+1;
            }
    }
}

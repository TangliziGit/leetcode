object Solution {
    private var xs, ys: Array[Int] = null
    
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        xs=nums1; ys=nums2
        if (xs.length == 0 && ys.length == 0) 0
        else{
            val (xlen, ylen) = (xs.length, ys.length)
            val (left, right) = (findKth(0, 0, (xlen+ylen)/2+1), findKth(0, 0, (xlen+ylen-1)/2+1))
            (left+right)/2.0
        }
    }
    
    def findKth(xi: Int, yi: Int, k: Int): Int = {
        if (xi>=xs.length) ys(yi+k-1)
        else if (yi>=ys.length) xs(xi+k-1)
        else if (k==1) xs(xi).min(ys(yi))
        else {
            var xMid, yMid: Int = Int.MaxValue
            if (xi+k/2-1 < xs.length) xMid=xs(xi+k/2-1)
            if (yi+k/2-1 < ys.length) yMid=ys(yi+k/2-1)

            if (xMid<yMid) findKth(xi+k/2, yi, k-k/2)
            else findKth(xi, yi+k/2, k-k/2)
        }
    }
}

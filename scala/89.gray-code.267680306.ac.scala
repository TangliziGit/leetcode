object Solution {
    def grayCode(n: Int): List[Int] = n match {
        case 0 => List[Int](0)
        case _ => grayCode(n-1) ++ grayCode(n-1).reverse.map(_ | (1<<n-1)).toList
    }
}

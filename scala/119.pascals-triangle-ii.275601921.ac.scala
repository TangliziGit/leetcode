object Solution {
    def getRow(rowIndex: Int): List[Int] = rowIndex match {
        case 0 => List(1)
        case n => 1 :: helper(getRow(rowIndex - 1))
    }
    
    def helper(xs: List[Int]): List[Int] = xs match {
        case x :: Nil => List(1)
        case a :: b :: xs =>
            ( a + b ) :: helper(b :: xs)
    }
}

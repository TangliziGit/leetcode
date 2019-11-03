object Solution {
    def generate(numRows: Int): List[List[Int]] = numRows match {
        case 0 => List()
        case 1 => List(List(1))
        case n => generate(numRows - 1) match {
            case x :: Nil => List(x, List(1, 1))
            case x :+ xs => (x :+ xs) :+ (1 :: helper(xs))
        }
    }
    
    def helper(xs: List[Int]): List[Int] = xs match {
        case x :: Nil => List(1)
        case a :: b :: xs =>
            ( a + b ) :: helper(b :: xs)
    }
}

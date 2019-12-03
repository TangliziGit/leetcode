object Solution {
    def isValid(s: String): Boolean = {
        val map = Map('(' -> ')', '[' -> ']', '{' -> '}').withDefaultValue(' ')
        
        // use List[Char] unless String, and you can use x :: xs pattern
        s.foldLeft(List[Char]()){
            case (x :: xs, ch) if map(x).equals(ch) => xs
            case (xs, ch) => ch +: xs
        }.isEmpty
    }
}

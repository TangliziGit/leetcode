object Solution {
    def combine(n: Int, k: Int): List[List[Int]] = 
        (1 to n).toList.combinations(k).toList
}

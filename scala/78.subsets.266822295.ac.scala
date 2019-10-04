object Solution {
    def subsets(nums: Array[Int]): List[List[Int]] =
        nums.foldLeft(List(List[Int]()))(
            (acc, x) => acc ++ acc.map(lis => x :: lis)
        )
    def subsets2(nums: Array[Int]): List[List[Int]] =
        nums.toSet.subsets.map(_.toList).toList
}

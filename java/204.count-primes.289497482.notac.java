import java.math.BigInteger;

// consider the Lehmer's formula
class Solution {
    public int countPrimes(int n) {
        return (int) LongStream.range(2, n)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .filter(x -> x.isProbablePrime(10))
            .count();
    }
}

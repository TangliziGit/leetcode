/**
 * @param {number} n
 * @param {number} k
 * @return {character}
 */
const findKthBit = (n, k) => {
    const helper = (n, k) => {
        if (n == 1 && k == 0) return false;

        const half = Math.floor((Math.pow(2, n) - 1) / 2);
        if (k < half) return helper(n-1, k);
        if (k == half) return true;
        return helper(n-1, 2*half-k)^true;
    };

    return helper(n, k-1)?'1':'0';
};


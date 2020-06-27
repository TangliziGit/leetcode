/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
const kthFactor = (n, k) => {
    let [cnt, i] = [0, 1];

    while (cnt < k) {
        if (n < i) return -1;
        if (n % i++ !== 0) continue;
        cnt++;
    }

    return i-1;
};


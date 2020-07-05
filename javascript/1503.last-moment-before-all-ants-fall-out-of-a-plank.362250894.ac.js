/**
 * @param {number} n
 * @param {number[]} left
 * @param {number[]} right
 * @return {number}
 */
const getLastMoment = (n, ls, rs) => {
    let ans = 0;
    for (const x of ls) ans = Math.max(ans, x);
    for (const x of rs) ans = Math.max(ans, n - x);
    return ans;
};


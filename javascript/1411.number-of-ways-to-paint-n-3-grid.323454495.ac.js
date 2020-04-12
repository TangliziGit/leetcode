/**
 * @param {number} n
 * @return {number}
 */
const mod = 1e9+7;
const numOfWays = (n) => {
    let ans = [6, 6];
    while (n-- !== 1) {
        let tmp = ans[0];
        ans[0] = (ans[0]*3 + ans[1]*2)%mod;
        ans[1] = (tmp*2 + ans[1]*2)%mod;
    }
    return (ans[0] + ans[1])%mod;
};

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
// debug重点：列dp表+回溯
const INF = 0x3f3f3f3f;
const maxs = (...xs) => xs
    .filter(x => x != undefined)
    .reduce((m, x) => Math.max(m, x), -INF);

const maxDotProduct = (xs, ys) => {
    const dp = Array(xs.length + 1).fill(0)
        .map(x => Array(ys.length + 1).fill(0));

    for (let i=1; i<=xs.length; i++)
        for (let j=1; j<=ys.length; j++) 
            dp[i][j] = maxs(
                xs[i-1]*ys[j-1]+dp[i-1][j-1], 
                xs[i-1]*ys[j-1], 
                (i==1 || j==1)? -INF: dp[i-1][j-1],
                (j==1)? -INF: dp[i][j-1],
                (i==1)? -INF: dp[i-1][j]
            );

    // console.log(dp);
    return dp[xs.length][ys.length];
};


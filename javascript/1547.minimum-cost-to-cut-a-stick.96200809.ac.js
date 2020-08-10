/**
 * @param {number} n
 * @param {number[]} cuts
 * @return {number}
 */
const minCost = (n, cuts) => {
    cuts.sort((x, y) => x - y);
    const INF = 0x3f3f3f3f;
    const dp = Array(cuts.length).fill(null).map(x => 
        Array(cuts.length).fill(null).map(y => null)
    );

    const solve = (i, j, a, b) => {
        // console.log(i, j);
        if (i == j) return b-a;
        if (i > j) return 0;
        if (dp[i][j] !== null) return dp[i][j];

        dp[i][j] = INF;
        for (let k=i; k<=j; k++) {
            const res = 
                solve(i, k-1, a, Math.min(b, cuts[k])) +
                solve(k+1, j, Math.max(a, cuts[k]), b) +
                b-a;
            const aa = solve(i, k-1, a, Math.min(b, cuts[k])) 
            const ab = solve(k+1, j, Math.max(a, cuts[k]), b) 
            
            dp[i][j] = Math.min(dp[i][j], 
                solve(i, k-1, a, Math.min(b, cuts[k])) +
                solve(k+1, j, Math.max(a, cuts[k]), b) +
                b-a
            );
            
            // console.log('res', i, k, j, res, b, a);
            // console.log('prev', aa)
            // console.log('pos', ab)
            
        }

        return dp[i][j];
    };
    
    // console.log(cuts);
    const res = solve(0, cuts.length-1, 0, n);
    // console.log(dp);
    return res;
};


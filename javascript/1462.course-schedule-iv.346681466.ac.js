/**
 * @param {number} n
 * @param {number[][]} prerequisites
 * @param {number[][]} queries
 * @return {boolean[]}
 */
const checkIfPrerequisite = (n, es, qs) => {
    let dp = Array(n).fill(0)
        .map(x => Array(n).fill(false));

    for (const e of es) 
        dp[e[0]][e[1]] = true;

    for (let k=0; k<n; k++)
        for (let i=0; i<n; i++) 
            for (let j=0; j<n; j++) 
                dp[i][j] = dp[i][j] || (dp[i][k] && dp[k][j]);

    let ans = [];
    for (const q of qs) 
        ans.push(dp[q[0]][q[1]]);
    return ans;
};


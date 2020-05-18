/**
 * @param {number[]} cost
 * @param {number} target
 * @return {string}
 */
let dp = null;
let wei = 0;

const greater = (xs, ys) => {
    if (xs[9] !== ys[9]) return xs[9] > ys[9];
    for (let i=8; i>=0; i--) if (xs[i] != ys[i])
        return xs[i] > ys[i];
    return false;
}

const knap = (cost, val) => {
    for (let i=cost; i<=wei; i++) {
        if (dp[i-cost][9] < 0) continue;
        
        const pre = dp[i];
        const now = dp[i-cost].concat();
        
        now[val]++;
        now[9]++;
        if (greater(now, pre)) dp[i] = now;
    }
}

const largestNumber = (cost, target) => {
    wei = target;
    dp = Array(wei);
    for (let i=0; i<=wei; i++) 
        dp[i] = Array(9).fill(0).concat([-1]);
    dp[0][9] = 0;
    
    for (let i=0; i<cost.length; i++) 
        knap(cost[i], i);

    const ans = dp[wei]
        .slice(0, 9)
        .reduce((ans, x, i) => (i+1+"").repeat(x) + ans, "");
    
    return (ans.length !== 0)?ans:"0";
};


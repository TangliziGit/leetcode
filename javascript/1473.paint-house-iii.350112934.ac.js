/**
 * @param {number[]} houses
 * @param {number[][]} cost
 * @param {number} m
 * @param {number} n
 * @param {number} target
 * @return {number}
 */
const minCost = (hs, cost, nh, nc, target) => {
    // hs = hs.map(x => (x==0)?-1:x);
    hs = hs.map(x => x-1);
    const INF = 0x3f3f3f3f;
    const data = Array(nh).fill(null)
        .map(x => Array(target+1).fill(null).
            map(x => Array(nc).fill(null)));

    const dp = (i, t, c) => {
        const icost = (cx) => {
            if (hs[i] === -1) return cost[i][cx];
            if (hs[i] === cx) return 0;
            return INF;
        }
        
        if (i === 0 && t === 1) return icost(c);
        if (i <= 0 || t < 0) return INF;
        if (data[i][t][c] != null) return data[i][t][c];
        
        data[i][t][c] = dp(i-1, t, c) + icost(c);
        for (let cx = 0; cx<nc; cx++) if (cx !== c) {
            const nex = dp(i-1, t-1, cx) + icost(c);
            if (data[i][t][c] <= nex) continue;
            data[i][t][c] = nex;
        }

        return data[i][t][c];
    };

    let ans = INF;
    for (let i = 0; i<nc; i++) 
        ans = Math.min(ans, dp(nh-1, target, i));
    
    return (ans>=INF)?-1:ans;
};


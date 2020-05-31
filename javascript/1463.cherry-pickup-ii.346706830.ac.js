/**
 * @param {number[][]} grid
 * @return {number}
 */
const cherryPickup = (G) => {
    const INF = 0x3f3f3f3f;
    const [ymax, xmax] = [G.length, G[0].length];
    let data = Array(ymax).fill(null)
        .map(x => Array(xmax).fill(null)
            .map(x => Array(xmax).fill(null)));

    const dp = (x1, x2, y) => {
        if (x1<0 || x2<0 || y<0 ||
            x1>=xmax || x2>=xmax || y>=ymax ) return -INF;
        if (x1 === 0 && x2 === xmax-1 && y === 0)
            return G[0][x1] + G[0][x2];
        if (y === 0) return -INF;
        if (data[y][x1][x2] !== null) return data[y][x1][x2];

        data[y][x1][x2] = -INF;
        for (let i=-1; i<=1; i++)
            for (let j=-1; j<=1; j++) {
                const val = dp(x1+i, x2+j, y-1) + G[y][x1] + 
                    ( (x2===x1)?0:G[y][x2] );
                data[y][x1][x2] = Math.max(val, data[y][x1][x2]);
            }
        return data[y][x1][x2];
    };

    let ans = 0;
    for (let i=0; i<xmax; i++)
        for (let j=0; j<xmax; j++) ans = Math.max(ans, dp(i, j, ymax-1));
    return ans;
};


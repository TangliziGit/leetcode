/**
 * @param {character[][]} matrix
 * @return {number}
 */
const maximalSquare = (ms) => {
    if (ms.length === 0 || ms[0].length === 0) return 0;
    
    const INF = 0x3f3f3f3f;
    const [ymax, xmax] = [ms.length, ms[0].length];
    const data = Array(ymax).fill(null)
        .map(x => Array(xmax).fill(null));
    
    const dp = (y, x) => {
        if (x >= xmax || y >= ymax) return INF;
        if (data[y][x] !== null) return data[y][x];

        if (y === ymax - 1 || x === xmax - 1 || ms[y][x] === '0')
            data[y][x] = (ms[y][x] === '1')?1:0;
        else 
            data[y][x] = Math.min(dp(y+1, x+1), dp(y+1, x), dp(y, x+1)) + 1;
        return data[y][x];
    }

    let ans = 0;
    for (let y = 0; y < ymax; y++)
        for (let x = 0; x < xmax; x++) ans = Math.max(ans, dp(y, x));
    console.log(data)
    
    return ans*ans;
};


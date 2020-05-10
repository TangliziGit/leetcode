/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {boolean[]} hasApple
 * @return {number}
 */
const dfs = (u, v, G, apple) => {
    // v is this node's father.
    let len = 0;
    for (const next of G[u]) if (next !== v) 
        len += dfs(next, u, G, apple) + 1;
    
    if (len === 0) {
        if (!apple[u]) return -1;
        return 0;
    }
    return len;
}

const minTime = (n, edges, hasApple) => {
    const G = {};
    for (const [u, v] of edges) {
        if (G[u] === undefined) G[u]=[];
        if (G[v] === undefined) G[v]=[];

        G[u].push(v);
        G[v].push(u);
    }

    const ans = dfs(0, -1, G, hasApple) * 2;
    return Math.max(0, ans);
};


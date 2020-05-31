/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number}
 */
const minReorder = (n, cs) => {
    const es = cs
        .reduce((es, x) => {
            if (es[x[0]] === undefined) es[x[0]] = [];
            if (es[x[1]] === undefined) es[x[1]] = [];
            es[x[0]].push([x[1], true]);
            es[x[1]].push([x[0], false]);
            return es;
        }, {});

    const dfs = (x, p) => es[x]
        .filter(e => e[0] !== p)
        .reduce((ans, e) => ans + dfs(e[0], x) + ((e[1])?1:0), 0);

    return dfs(0, -1);
};


/**
 * @param {string[][]} favoriteCompanies
 * @return {number[]}
 */
let set = null;

const find = (x) => (set[x] === x)?x:(set[x] = find(set[x]));
const join = (x, y) => set[find(x)] = find(y);
const include = (xs, ys) => {
    for (const y of ys) if (!xs.has(y))
        return false;
    return true;
}

const peopleIndexes = (cs) => {
    set = Array(cs.length).fill(0).map((x, i) => i);
    cs = cs.map((x) => new Set(x));
    
    for (let xi=0; xi<cs.length; xi++) {
        for (let yi=xi+1; yi<cs.length; yi++) {
            const [x, y] = [find(xi), find(yi)]
            if (include(cs[x], cs[y])) join(y, x);
            if (include(cs[y], cs[x])) join(x, y);
        }
    }

    return set.reduce((ans, x, i) => {
        if (x === i) ans.push(x);
        return ans;
    }, []);
};


/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number[]}
 */
const getStrongest = (arr, k) => {
    const median = arr.sort((x, y) => x-y)[Math.floor((arr.length-1) / 2)];
    const cmp = (x, y) => {
        if (x[0] == y[0]) return y[1] - x[1];
        return y[0] - x[0];
    };
    
    return arr 
        .map(x => [Math.abs(x-median), x])
        .sort(cmp)
        .slice(0, k)
        .map(x => x[1]);
};


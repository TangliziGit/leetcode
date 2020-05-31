/**
 * @param {number[]} target
 * @param {number[]} arr
 * @return {boolean}
 */
const canBeEqual = (xs, ys) => {
    xs = xs.sort();
    ys = ys.sort();
    for (let i=0; i<xs.length; i++)
        if (xs[i] !== ys[i]) return false;
    return true;
};


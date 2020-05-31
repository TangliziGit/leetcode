/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
const hasAllCodes = (xs, k) => {
    const p = Math.pow(2, k-1);
    const vis = new Set();
    let val = 0; // xs.slice(0, k);

    for (let i=0; i<=xs.length; i++) {
        if (i-k>=0 && !vis.has(val)) vis.add(val);

        if (i-k>=0) val -= parseInt(xs[i-k])*p;
        if (i!==xs.length) val = val*2 + parseInt(xs[i]);
    }

    return vis.size === 2*p;
};


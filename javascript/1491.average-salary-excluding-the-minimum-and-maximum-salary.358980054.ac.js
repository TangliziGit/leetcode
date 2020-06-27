/**
 * @param {number[]} salary
 * @return {number}
 */
const average = (xs) => {
    let [imax, imin] = [0, 0];

    for (let i=0; i<xs.length; i++) {
        if (xs[imax] < xs[i]) imax = i;
        if (xs[imin] > xs[i]) imin = i;
    }

    xs[imax] = xs[imin] = 0;
    return xs.reduce((s, x) => s+x, 0) / (xs.length - 2);
};


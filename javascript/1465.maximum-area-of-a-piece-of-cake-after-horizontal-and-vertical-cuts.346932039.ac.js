/**
 * @param {number} h
 * @param {number} w
 * @param {number[]} horizontalCuts
 * @param {number[]} verticalCuts
 * @return {number}
 */
const maxArea = (ymax, xmax, ys, xs) => {
    ys.push(ymax);
    xs.push(xmax);
    const mod = 1e9+7;
    const cmp = (x, y) => x - y;
    const [y, x] = [
        ys.sort(cmp).reduce(([max, prev], x) => 
            [Math.max(max, x-prev), x], [0, 0])[0],
        xs.sort(cmp).reduce(([max, prev], x) => 
            [Math.max(max, x-prev), x], [0, 0])[0],
    ];

    console.log(ys.sort(), xs.sort());
    console.log(y, x);
    return (y*x)%mod;
};


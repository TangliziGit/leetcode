/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
const findLeastNumOfUniqueInts = (arr, k) => {
    const dic = arr
        .reduce((acc, x) => {
            acc[x] = (acc[x] || 0) + 1;
            return acc;
        }, {});
    const xs = [];

    for (const key of Object.keys(dic))
        xs.push([key, dic[key]]);

    xs.sort((x, y) => x[1] - y[1]);

    let num = 0;
    for (const item of xs) {
        if (k - item[1] < 0) break;
        k -= item[1];
        num+=1;
    }

    return xs.length - num;
};


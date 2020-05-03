/**
 * @param {string[][]} paths
 * @return {string}
 */
var destCity = function(paths) {
    const total = new Set();
    const dic = {};
    
    for (const [from, to] of paths) {
        total.add(from);
        total.add(to);
        dic[from] = 0;
    }
    
    let ans = null;
    for (const point of total) 
        if (dic[point] === undefined) {
            ans = point;
            break;
        }
    
    return ans;
};

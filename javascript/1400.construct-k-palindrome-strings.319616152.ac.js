/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
const canConstruct = (s, k) => {
    let map = s.split('')
        .reduce((acc, x) => {
            acc[x] = (acc[x] || 0) + 1;
            return acc
        }, {});
    let xs = Object.values(map);
    
    let n = xs.filter(x => x%2==1).length;
    let m = xs.filter(x => x%2==0).length;
    let min = (n==0)?( (m==0)?0:1 ):n;
    let max = s.length;
    
    return min <= k && k <= max;
}

/**
 * @param {number} n
 * @return {number}
 */
const countLargestGroup = (n) => {
    let map = {};
    for (var i = 1; i <= n; i++) {
        let num = ("" + i).split('').map(x => parseInt(x)).reduce((acc, x) => acc+x);
        map[num] = (map[num] || 0) + 1;
    }
    
    let cnt=0, m=0;
    for (const i of Object.values(map)) {
        if (m === i) cnt+=1;
        else if (m < i) {
            m = i; cnt = 1;
        }
    }
    
    return cnt;
};

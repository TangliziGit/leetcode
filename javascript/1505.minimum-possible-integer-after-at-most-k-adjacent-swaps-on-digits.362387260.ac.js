/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
const minInteger = (ns, k) => {
    const bit = Array(ns.length+1).fill(0);
    const lowbit = (x) => x & (-x);
    const add = (idx, x) => {
        for (let i=idx; i<=bit.length; i+=lowbit(i)) 
            bit[i] += x;
    };
    const get = (idx) => {
        let sum = 0;
        for (let i=idx; i>0; i-=lowbit(i))
            sum += bit[i];
        return sum;
    };
    
    const ptrs = Array(10).fill(0);
    const vis = Array(ns.length).fill(false);
    const ps = ns.split('')
        .reduce((m, x, i) => {
            x = parseInt(x);
            if (m[x] === undefined) m[x] = [];
            m[x].push(i);
            return m;
        }, Array(10));

    console.log(ps);
    if (k > (ns.length-1)*ns.length/2) return ns.split('').sort((x, y) => x-y).join('');
    
    let ans = "";
    while (k > 0) {
        let flg = false;
        for (let i=0; i<=9; i++) if (ps[i] !== undefined) {
            let pos = ps[i][ptrs[i]];
            let sum = get(pos+1);
            if (pos === undefined || pos - sum > k) continue;
            ptrs[i]++;
            k -= pos - sum;
            ans += i;
            vis[pos] = true;
            add(pos+1, 1);
            flg = true;
            break;
        }
        if (!flg) break;
    }

    for (let i=0; i<ns.length; i++) if (!vis[i])
        ans += ns[i];
    return ans;
};


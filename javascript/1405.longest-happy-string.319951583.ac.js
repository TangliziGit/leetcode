/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {string}
 */
const argmax = (arr) =>
    arr.map((x, i) => [x, i]).reduce((a, x) => (a[0] > x[0])?a:x)[1];
const char = (x) => String.fromCharCode('a'.charCodeAt(0) + x);
const state = (a, b, c, s) => 1e7*a + 1e4*b + 10*c + s;
const maxlen = (s1, s2) => (s1.length > s2.length)?s1:s2;

let data = {}
const dp = (a, b, c, s) => {
    const sta = state(a, b, c, s);
    if (data[sta] !== undefined) return data[sta];
    
    let d = "";
    let ns = [a, b, c];
    for (let i = 0; i<3; i++) if (i != s) {
        if (ns[i] >= 2) {
            let tmp = ns[i];
            ns[i] -= 2;
            d = maxlen(d, dp(ns[0], ns[1], ns[2], i) + char(i) + char(i));
            ns[i] = tmp;
        } 
        
        if (ns[i] >= 1) {
            let tmp = ns[i];
            ns[i]--;
            d = maxlen(d, dp(ns[0], ns[1], ns[2], i) + char(i));
            ns[i] = tmp;
        }
    }
    data[sta] = d;
    return d;
}

const longestDiverseString = (a, b, c) => dp(a, b, c, 3);

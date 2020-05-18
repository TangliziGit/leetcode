/**
 * @param {number} n
 * @return {string[]}
 */
const gcd = (a, b) => (b==0)?a:gcd(b, a%b);

const helper = (n) => {
    let ans = [];
    for (let i=1; i<n; i++) if (gcd(i, n) === 1)
        ans.push(i+'/'+n);
    return ans;
};

const simplifiedFractions = (n) => {
    let ans = [];
    for (let i=2; i<=n; i++) 
        ans = ans.concat(helper(i));
    return ans;
};


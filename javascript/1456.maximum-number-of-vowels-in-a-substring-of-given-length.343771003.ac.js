/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
const vowel = (x) => /[aiueo]/.test(x)? 1: 0;

const maxVowels = (s, k) => {
    let [ans, sum] = [0, 0];

    for (let i=0; i<s.length; i++) {
        sum += vowel(s[i]);
        if (i-k >= 0) sum-=vowel(s[i-k]);
        ans = Math.max(ans, sum);
    }

    return ans;
};


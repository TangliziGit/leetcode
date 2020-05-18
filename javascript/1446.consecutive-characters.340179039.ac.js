/**
 * @param {string} s
 * @return {number}
 */
const maxPower = (str) => {
    let pre = str[0];
    let [cnt, ans] = [1, 1];
    for (let i=1; i<str.length; i++) {
        if (str[i] === pre) cnt++;
        else {
            ans = Math.max(ans, cnt);
            cnt = 1;
            pre = str[i];
        }   
    }
    return Math.max(ans, cnt);
};


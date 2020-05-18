/**
 * @param {string} text
 * @return {string}
 */
const arrangeWords = (text) => {
    const ans = text 
        .toLowerCase()
        .split(' ')
        .map((x, i) => [x, i])
        .sort((a, b) => {
            if (a[0].length !== b[0].length) return a[0].length - b[0].length;
            return a[1] - b[1];
        })
        .map((x) => x[0])
        .join(' ');
    return ans.charAt(0).toUpperCase() + ans.slice(1);
}


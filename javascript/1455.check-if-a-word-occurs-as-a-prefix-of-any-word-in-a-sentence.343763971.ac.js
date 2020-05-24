/**
 * @param {string} sentence
 * @param {string} searchWord
 * @return {number}
 */
const isPrefixOfWord = (sentence, word) => {
    const ans = sentence
        .split(' ')
        .map((x, i) => [x, i])
        .filter(x => x[0].startsWith(word));
    
    if (ans.length === 0) return -1;
    return ans[0][1]+1;
}


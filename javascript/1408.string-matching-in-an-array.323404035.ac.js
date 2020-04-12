/**
 * @param {string[]} words
 * @return {string[]}
 */
const check = (word, words) => {
    for (const word2 of words) if (word !== word2) {
        if (word2.length > word.length && word2.includes(word) ) 
            return true;
    }
    return false;
}

const stringMatching = (words) => {
    let ans = [];
    
    for (const word of words) {
        if (check(word, words)) ans.push(word);
    }
    
    return ans;
};

/**
 * @param {string} s
 * @return {number}
 */
const maxScore = (str) => {
    const zeros = [0];
    
    for (const s of str) {
        if (s === '0')
            zeros.push(zeros[zeros.length-1]+1);
        else 
            zeros.push(zeros[zeros.length-1]);
    }
    
    let score = 0;
    for (let i=1; i<str.length; i++) {
        const sleft = zeros[i];
        const sright = str.length - i - (zeros[zeros.length-1]-zeros[i]);
        score = Math.max(score, sleft + sright);
    }
    
    return score;
};

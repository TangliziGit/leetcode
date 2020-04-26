/**
 * @param {number[]} cardPoints
 * @param {number} k
 * @return {number}
 */
const maxScore = (points, k) => {
    const [left, rigth] = [[0], [0]];
    
    for (let i=0; i<points.length; i++) 
        left.push(left[left.length-1]+points[i]);
    for (let i=points.length-1; i>=0; i--) 
        rigth.push(rigth[rigth.length-1]+points[i]);
    
    let score = left[k];
    for (let l=0; l<=k; l++) 
        score = Math.max(score, left[l]+rigth[k-l])
    return score;
};

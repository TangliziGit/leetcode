/**
 * @param {number[]} nums
 * @return {number[]}
 */
const minSubsequence = (nums) => {
    nums = nums.sort((x, y) => y-x);
    
    const sum = nums.reduce((sum, x) => sum+x, 0);
    let sum2 = 0, arr = [];
    for (const x of nums) {
        sum2 += x;
        arr.push(x);
        if (sum2 > sum - sum2) break;
    }
    return arr;
};

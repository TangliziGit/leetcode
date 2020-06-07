/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */
const shuffle = (nums, n) => {
    let ans = Array(nums).fill(null);

    for (let i = 0; i<2*n; i++) {
        const idx = Math.floor(i / 2);
        
        if (i%2==1) ans[i] = nums[idx+n];
        else ans[i] = nums[idx];
    }

    return ans;
};


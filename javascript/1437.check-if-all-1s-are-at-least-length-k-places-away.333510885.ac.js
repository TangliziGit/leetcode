/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var kLengthApart = function(nums, k) {
    let step = -1;
    for (let i=0; i<nums.length; i++) {
        if (nums[i] === 1) {
            if (step !== -1 && step < k) return false;
            step = 0;
        } else if (step !== -1) 
            step++;
    }
    return true;
};

/**
 * @param {number[]} nums
 * @return {number[]}
 */
const runningSum = (nums) => nums
    .reduce((ans, x) => {
        ans.push(ans[ans.length-1] + x);
        return ans;
    }, [0]).slice(1);


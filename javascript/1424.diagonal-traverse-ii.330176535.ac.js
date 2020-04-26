/**
 * @param {number[][]} nums
 * @return {number[]}
 */
const findDiagonalOrder = (nums) => {
    let xmax = 0;
    for (let y=0; y<nums.length; y++) 
        xmax = Math.max(xmax, nums[y].length);
    
    const result = Array(nums.length + xmax-1); 
    for (let i=0; i<result.length; i++)
        result[i] = [];
    
    for (let y=nums.length-1; y>=0; y--) 
        for (let x=0; x<nums[y].length; x++) 
            result[x+y].push(nums[y][x]);
    
    const stack = [];
    for (const xs of result) 
        for (const x of xs)
            stack.push(x);
    
    return stack;
}

/**
 * @param {number[]} nums
 * @return {number}
 */
const longestSubarray = (xs) => {
    const INF = 0x3f3f3f3f;
    const [left, right] = [
        Array(xs.length).fill(0),
        Array(xs.length).fill(0)
    ];

    let prev = -1;
    for (let i=0; i<xs.length; i++) {
        if (xs[i] === 0) {prev=i; continue;}
        left[i] = i-prev;
    }

    prev = xs.length;
    for (let i=xs.length-1; i>=0; i--) {
        if (xs[i] === 0) {prev=i; continue;}
        right[i] = prev-i;
    }

    let ans = 0;
    for (let i=1; i<xs.length-1; i++) {
         if (xs[i] === 0) 
            ans = Math.max(ans, left[i-1]+right[i+1]);
    }
    
    ans = Math.max(ans, left[xs.length-2]);
    ans = Math.max(ans, right[1]);

    return ans;
};


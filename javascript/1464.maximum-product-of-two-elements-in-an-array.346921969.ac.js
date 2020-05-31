/**
 * @param {number[]} nums
 * @return {number}
 */
const maxProduct = (ns) => {
    let ans = (ns[0]-1)*(ns[1]-1);
    for (let i=0; i<ns.length; i++)
        for (let j=i+1; j<ns.length; j++) 
            ans = Math.max(ans, (ns[i]-1)*(ns[j]-1));
    return ans;
};


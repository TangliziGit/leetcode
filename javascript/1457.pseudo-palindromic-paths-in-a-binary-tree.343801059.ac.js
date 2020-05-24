/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
const check = (arr) => {
    const cnt = arr.slice(1).filter(x => x%2===1).length;
    if (arr[0] % 2 === 0) 
        return cnt === 0;
    return cnt === 1;
};

const dfs = (x, arr) => {
    if (x === null) return 0;

    arr[x.val]++; arr[0]++;
    let cnt = dfs(x.left, arr) + dfs(x.right, arr);

    if (x.left === null && x.right === null && check(arr))
        cnt++;

    arr[x.val]--; arr[0]--;

    return cnt;
};

const pseudoPalindromicPaths = (root) => dfs(root, Array(10).fill(0));


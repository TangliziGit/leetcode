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
const dfs = (node, val) => {
    let cnt = 0;
    if (node === null) return 0;
    if (node.val >= val) cnt++;
    cnt += dfs(node.left, Math.max(node.val, val));
    cnt += dfs(node.right, Math.max(node.val, val));
    return cnt;
};

const goodNodes = (root) => dfs(root, root.val);


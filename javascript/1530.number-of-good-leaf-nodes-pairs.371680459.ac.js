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
 * @param {number} distance
 * @return {number}
 */
const countPairs = (root, dis) => {
    const onehot = (idx = null) => {
        const res = Array(10).fill(0)
        if (idx !== null) res[idx] = 1;
        return res;
    }

    const solve = (node) => {
        if (node === null) return [0, onehot()];
        // console.log(node.left, node.right);
        if (node.left === null && node.right === null) 
            return [0, onehot(0)];

        const [nl, ls] = solve(node.left);
        const [nr, rs] = solve(node.right);
        let [n, ns] = [nr+nl, onehot()];

        for (let li=0; li<ls.length; li++)
            for (let ri=0; ri<=dis-li-2; ri++) 
                n += ls[li]*rs[ri];

        for (let li=0; li<ls.length-1; li++)
            ns[li+1] += ls[li];
        for (let ri=0; ri<rs.length-1; ri++)
            ns[ri+1] += rs[ri];

        console.log(node.val, n, ns);
        return [n, ns];
    }
    
    return solve(root)[0];
};


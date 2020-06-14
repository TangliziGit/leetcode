/**
 * @param {number} n
 * @param {number[]} parent
 */
var TreeAncestor = function(n, parent) {
    this.parent = parent;
    return this;
};

/** 
 * @param {number} node 
 * @param {number} k
 * @return {number}
 */
TreeAncestor.prototype.getKthAncestor = function(node, k) {
    let ans = node;
    while (k --> 0 && ans != -1) 
        ans = this.parent[ans];
    return ans;
};

/** 
 * Your TreeAncestor object will be instantiated and called as such:
 * var obj = new TreeAncestor(n, parent)
 * var param_1 = obj.getKthAncestor(node,k)
 */


/**
 * @param {string} homepage
 */
var BrowserHistory = function(homepage) {
    this.arr = Array(100).fill(null);
    this.arr[0] = homepage;

    this.i = 0;
    this.siz = 1;

    return this;
};

/** 
 * @param {string} url
 * @return {void}
 */
BrowserHistory.prototype.visit = function(url) {
    this.arr[++this.i] = url;
    this.siz = this.i+1;
};

/** 
 * @param {number} steps
 * @return {string}
 */
BrowserHistory.prototype.back = function(steps) {
    return this.arr[this.i = Math.max(0, this.i - steps)];
};

/** 
 * @param {number} steps
 * @return {string}
 */
BrowserHistory.prototype.forward = function(steps) {
    return this.arr[this.i = Math.min(this.siz-1, this.i + steps)];
};

/** 
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = new BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */

// [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

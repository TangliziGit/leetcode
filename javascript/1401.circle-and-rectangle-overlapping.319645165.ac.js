/**
 * @param {number} radius
 * @param {number} x_center
 * @param {number} y_center
 * @param {number} x1
 * @param {number} y1
 * @param {number} x2
 * @param {number} y2
 * @return {boolean}
 */
const rect = (ox, oy, x1, x2, y1, y2) => 
    x1 <= ox && ox <= x2 && y1 <= oy && oy <= y2 
const circle = (ox, oy, R, xx, yy) => 
    (ox-xx)*(ox-xx) + (oy-yy)*(oy-yy) <= R*R

const checkOverlap = (R, ox, oy, x1, y1, x2, y2) => {
    const rects = [
        [x1, x2, y1-R, y2+R],
        [x1-R, x2+R, y1, y2]
    ];
    const cirs = [
        [x1, y2], 
        [x1, y1], 
        [x2, y1], 
        [x2, y2]
    ];
    
    const r = rects.reduce((a, x) => a || rect(ox, oy, x[0], x[1], x[2], x[3]), false);
    const c = cirs.reduce((a, x) => a || circle(ox, oy, R, x[0], x[1]), false);
    
    return r || c;
};

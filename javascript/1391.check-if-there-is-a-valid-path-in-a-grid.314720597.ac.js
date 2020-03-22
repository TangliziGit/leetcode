/**
 * @param {number[][]} grid
 * @return {boolean}
 */
// 0
//1 3
// 2
const open = [
    [-1, 3, -1, 1],
    [2, -1, 0, -1],
    [-1, 2, 1, -1],
    [-1, -1, 3, 2],
    [1, 0, -1, -1],
    [3, -1, -1, 0],
];

const dirs = [
    [0, -1], [-1, 0], [0, 1], [1, 0]
];

const dirHelper = (_dir, type) => {
    const dir = open[type-1][(_dir+2)%4];
    if (dir == -1) return [[0, 0], -1];
    return [dirs[dir], dir];
};


const solve = (sdir, grid) => {
    const [ex, ey] = [grid[0].length-1, grid.length-1];
    const check = (x, y) => (x >= 0 && y >= 0 && x<=ex && y<=ey);
    let [x, y, dir] = [0, 0, sdir];
    
    while (check(x, y)) {
        const [[dx, dy], d] = dirHelper(dir, grid[y][x]);
        if (d == -1) return false;
        if (x == ex && y == ey) return true;
        
        x += dx;
        y += dy;
        dir = d;
    }
    return x==ex && y==ey;
}

const hasValidPath = (grid) => {
    const sdir = open[grid[0][0]-1].reduce((arr, x) => {
        if (x!=-1) arr.push((x+2)%4);
        return arr;
    }, []);
    return solve(sdir[0], grid) || solve(sdir[1], grid);
};

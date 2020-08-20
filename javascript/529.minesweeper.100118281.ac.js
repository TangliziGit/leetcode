/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
const updateBoard = (map, click) => {
    if (map === undefined || map.length === 0 || map[0].length === 0)
        return map;

    const [xmax, ymax] = [map[0].length, map.length];
    const dir = (() => {
        let dir = [];
        for (let y = -1; y <= 1; y++)
            for (let x = -1; x <= 1; x++)
                dir.push([y, x]);
        return dir;
    })();

    const adjacent = (() => {
        const adjacent = Array(ymax).fill(null).map( y =>
            Array(xmax).fill(null).map( x => 0)
        );

        for (let y = 0; y < ymax; y++) {
            for (let x = 0; x < xmax; x++) {
                if (map[y][x] === 'M') {

                    for (const [dy, dx] of dir) {
                        let [_y, _x] = [dy+y, dx+x];
            
                        if (!(_x>=0 && _y>=0 && _x<xmax && _y<ymax)) continue;
                        adjacent[_y][_x] += 1;
                    }
                }
            }
        }

        return adjacent;
    })();

    const helper = ([cy, cx]) => {
        const cur = map[cy][cx];

        if (cur === 'M') {
            map[cy][cx] = 'X';
        } else if (cur === 'E' && adjacent[cy][cx] == 0) {
            map[cy][cx] = 'B';

            for (const [dy, dx] of dir) {
                let [y, x] = [dy+cy, dx+cx];
    
                if (!(x>=0 && y>=0 && x<xmax && y<ymax)) continue;
                if (map[y][x] !== 'E') continue;

                helper([y, x]);
            }
        } else if (cur === 'E') {
            map[cy][cx] = ""+adjacent[cy][cx];
        }
    };

    helper(click);
    return map;
};

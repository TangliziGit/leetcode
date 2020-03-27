/**
 * @param {number[]} deck
 * @return {boolean}
 */
const gcd = (a, b) => (b == 0)? a: gcd(b, a%b);

const hasGroupsSizeX = (deck) => {
    const xs = Object.values(deck
        .reduce((map, x) => {
            map[x] = (map[x] || 0) + 1;
            return map;
        }, {})
    );
    
    return xs.reduce(gcd, xs[0]) >= 2;
};

/**
 * @param {number[][]} mat
 * @return {number}
 */
const numSubmat = (mat) => {
    const ny = mat.length, nx = mat[0].length;
    const helper = (hs) => {
        let res = 0, len = 0;
        for (let i=0; i<nx; i++) {
            len = (hs[i] == 0)?0:len+1;
            res += len;
        }
        return res;
    };

    let ans = 0;
    for (let upper=0; upper < ny; upper++) {
        let hei = Array(nx).fill(1);

        for (let lower=upper; lower < ny; lower++) {
            for (let i=0; i<nx; i++) hei[i] &= mat[lower][i];
            ans += helper(hei);
        }
    }

    return ans;
};


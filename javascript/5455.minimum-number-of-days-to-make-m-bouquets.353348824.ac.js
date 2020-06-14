/**
 * @param {number[]} bloomDay
 * @param {number} m
 * @param {number} k
 * @return {number}
 */
const minDays = (arr, m, k) => {
    const check = (xmax) => {
        let [l, r, cnt] = [0, 0, 0];

        while (r < arr.length) {
            if (arr[r] > xmax) 
                l = r = r+1;
            else {
                if (r-l == k-1) {
                    l = r = r+1;
                    cnt++;
                } else r++;
            }
        }

        return cnt >= m;
    };

    const solve = (arr) => {
        const max = Math.max(...arr);
        let [l, r, mid] = [0, max, Math.floor(max/2)];

        while (l < r) {
            if (check(mid)) r = mid-1;
            else l = mid+1;
            mid = Math.floor((r+l)/2);
        }

        for (let i=Math.max(0, l-2); i<=Math.min(max, r+2); i++)
            if (check(i)) return i;
        return -1;
    };

    if (arr.length < m*k) 
        return -1;
    return solve(arr);
};


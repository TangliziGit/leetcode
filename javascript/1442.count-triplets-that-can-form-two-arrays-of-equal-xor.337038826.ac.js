/**
 * @param {number[]} arr
 * @return {number}
 */
const countTriplets = (arr) => {
    let cnt = 0;
    const range = Array(arr.length);

    for (let i = 0; i<arr.length; i++) {
        range[i] = Array(arr.length);
        range[i][i] = arr[i];
        for (let j = i+1; j<arr.length; j++) {
            range[i][j] = range[i][j-1] ^ arr[j];
        }
    }
            
    for (let i = 0; i<arr.length; i++)
        for (let j = i+1; j<arr.length; j++)
            for (let k = j; k<arr.length; k++) 
                if (range[i][j-1] === range[j][k]) cnt++;

    return cnt;
};


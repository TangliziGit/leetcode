/**
 * @param {number[]} arr
 * @return {boolean}
 */
const canMakeArithmeticProgression = (arr) => {
    arr.sort((x, y) => x-y);
    console.log(arr);
    let diff = arr[1] - arr[0];
    for (let i=1; i<arr.length; i++) 
        if (diff !== arr[i] - arr[i-1]) return false;
    return true;
};


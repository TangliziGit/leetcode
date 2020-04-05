/**
 * @param {number[]} satisfaction
 * @return {number}
 */
const maxSatisfaction = (arr) => arr
  .sort((x, y) => y-x)
  .reduce((acc, x) => {
      //[sum, prev, ans]
      acc[1] += x;
      acc[0] += acc[1];
      acc[2] = Math.max(acc[2], acc[0]);
      return acc;
  }, [0, 0, 0])[2];

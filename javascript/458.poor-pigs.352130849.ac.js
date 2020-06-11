/**
 * @param {number} buckets
 * @param {number} minutesToDie
 * @param {number} minutesToTest
 * @return {number}
 */
const poorPigs = (buckets, minutesToDie, minutesToTest) => {
    const st = Math.floor(minutesToTest / minutesToDie) + 1;
    return Math.ceil(Math.log(buckets)/Math.log(st));
};

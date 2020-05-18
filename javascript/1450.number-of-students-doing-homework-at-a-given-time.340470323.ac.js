/**
 * @param {number[]} startTime
 * @param {number[]} endTime
 * @param {number} queryTime
 * @return {number}
 */
const busyStudent = (startTime, endTime, queryTime) => {
    let ans = 0;
    for (let i=0; i<startTime.length; i++) 
        if (startTime[i] <= queryTime && queryTime <= endTime[i])
            ans++;
    return ans;
};


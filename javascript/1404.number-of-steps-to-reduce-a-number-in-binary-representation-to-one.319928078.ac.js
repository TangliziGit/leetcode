/**
 * @param {string} s
 * @return {number}
 */
const numSteps = (s) => {
    s = '0' + s;
    let ptr = s.length - 1;
    let cnt = 0;
    
    while (ptr>0) {
        if (ptr == 1 && s.charAt(0) === '0' && s.charAt(1) === '1')
            break;
        if (s.charAt(ptr) === '0') {
            while (ptr>0 && s.charAt(ptr) === '0') ptr--, cnt++;
        } else if (s.charAt(ptr) === '1') {
            ptr--; cnt+=2;
            while (ptr>0 && s.charAt(ptr) === '1') ptr--, cnt++;
            s = s.substr(0, ptr) + '1';
        }
    }
    
    return cnt;
};

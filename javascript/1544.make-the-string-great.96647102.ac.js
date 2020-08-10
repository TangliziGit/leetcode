/**
 * @param {string} s
 * @return {string}
 */
const makeGood = (s) => {
    const isUpper = (ch) => 'A' <= ch && ch <= 'Z';
    const checkAndReplace = (s, i) => {
        if (i < 0 || i+1 >= s.length) return [s, false];
        const [prev, pos] = [isUpper(s[i]), isUpper(s[i+1])];

        console.log(s, i);
        if (prev === pos) return [s, false];
        if (s[i].toUpperCase() !== s[i+1].toUpperCase()) 
            return [s, false];
        s = s.slice(0, i) + s.slice(i+2);
        return [s, true];
    };

    let i = 0;
    while (i < s.length) {
        let flag = false;
        [s, flag] = checkAndReplace(s, i);
        
        if (flag) i=Math.max(0, i-1);
        else i++;
    }

    return s;
};


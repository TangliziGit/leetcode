/**
 * @param {string} croakOfFrogs
 * @return {number}
 */
const minNumberOfFrogs = (croaks) => {
    let count = (croaks.length>0)?1:0, number = 0;
    let states = [], croak = "croak";
    for (const ch of croaks) {
        if (croak.includes(ch)) {
            const next = croak.indexOf(ch);
            
            if (next == 0) {
                // if (number != 0) count++;
                number++;
                count = Math.max(count, number);
                states.push(0);
            } else {
                const pos = states.indexOf(next-1);
                if (pos == -1) return -1;
                states[pos]++;
                if (next == 4) number--;
            }
                
        } else return -1;
    }
    
    return number==0?count:-1;
};

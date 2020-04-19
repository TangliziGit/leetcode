/**
 * @param {string} s
 * @return {string}
 */
const helper = (digs, lets) => {
    let res = "";
    for (let i = 0; i<Math.min(lets.length, digs.length); i++) 
        res = res + digs[i] + lets[i];
    return res;
}

const reformat = (s) => {
    const [dig, _let] = [/[0-9]/, /[a-z]/];
    const [digs, lets] = [[], []];
    
    for (const ch of s) {
        if (dig.test(ch)) digs.push(ch);
        if (_let.test(ch)) lets.push(ch);
    }
    
    if (lets.length === digs.length + 1)
        return helper(lets, digs) + lets[lets.length - 1];
    if (lets.length === digs.length - 1)
        return helper(digs, lets) + digs[digs.length - 1];
    if (lets.length === digs.length)
        return helper(digs, lets);
    return "";
};

/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
const buildArray = (target, n) => {
    let i = 1;
    const cmd = [];
    
    for (const t of target) {
        while (i++ !== t) {
            cmd.push('Push');
            cmd.push('Pop');
        }
        cmd.push('Push');
    }

    console.log(cmd);
    return cmd;
};


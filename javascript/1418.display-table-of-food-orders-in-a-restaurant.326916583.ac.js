/**
 * @param {string[][]} orders
 * @return {string[][]}
 */

const displayTable = (orders) => {
    const foods = {};
    const table = {};
    const foodList = [...new Set(orders
        .map(x => x[2])
        .sort())];//(a, b) => a.charCodeAt(0) - b.charCodeAt(0)))];
    
    foodList
        .forEach((x, i) => foods[x] = i);
    for (const order of orders) {
        if (table[order[1]] === undefined)
            table[order[1]] = Array(foodList.length).fill(0);
        table[order[1]][foods[order[2]]]++;
    }
    
    const result = [["Table"].concat(foodList)];
    for (const key of Object.keys(table)) 
        result.push([key].concat(table[key].map(x => ''+x)));
    
    return result;
};

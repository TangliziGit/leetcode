const restoreString = (s, is) => {
    const arr = Array(s.length).fill('x');

    for (let i =0; i<s.length; i++) 
        arr[is[i]] = s[i];

    return arr.join('');
};


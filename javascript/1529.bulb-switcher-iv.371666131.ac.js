const minFlips = (ts) => {
    let [sta, cnt] = [0, 0];

    for (const t of ts) {
        const tmp = t ^ sta;

        if (tmp == 0) continue;
        sta ^= 1;
        cnt++;
    }

    return cnt;
};


/**
 * @param {number} n
 * @param {number[][]} dependencies
 * @param {number} k
 * @return {number}
 */
function Node(from, to, next) {
    this.from = from;
    this.to = to;
    this.next = next;
}

const minNumberOfSemesters = (n, es, k) => {
    const edges = [];
    const head = Array(n+1).fill(-1);
    const addEdge = (e) => {
        edges.push(new Node(e[0], e[1], head[e[0]]));
        head[e[0]] = edges.length-1;
    };

    let [stack, ind, outd] = [[], Array(n+1).fill(0), Array(n+1).fill(0)];
    for (let i=0; i<es.length; i++) {
        ind[es[i][1]]++;
        outd[es[i][0]]++;
        addEdge(es[i]);
    }

    for (let i=1; i<=n; i++) if (ind[i] === 0)
        stack.push(i);

    let [ans, cnt] = [0, 0];
    while (cnt < n) {
        const tmp = [];
        
        stack.sort((x, y) => {
            if (outd[x] != outd[y]) return outd[x] - outd[y];
            return x - y;
        })
        
        for (let ii=0; stack.length>0 && ii<k; ii++) {
            tmp.push(stack.pop());
            cnt++;
        }

        for (const from of tmp) {
            for (let i=head[from]; i!=-1; i=edges[i].next) {
                const e = edges[i];
                outd[e.from]--;
                if (--ind[e.to] === 0)
                    stack.push(e.to);
            }
        }
        
        console.log(`${ans}, tmp: [${tmp}], stack: [${stack}], ind: [${ind}]`);
        ans++;
    }

    return ans;
};


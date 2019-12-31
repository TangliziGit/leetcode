// version 2, dfs O(n)
class Solution {
    
    private boolean[] vis, ok;
    private Map<Integer, List<Integer>> edges;
    
    public boolean canFinish(int n, int[][] pre) {
        edges = new HashMap<>();
        vis = new boolean[n];
        ok = new boolean[n];
        
        for (int[] pair: pre) {
            edges.computeIfAbsent(pair[1], x -> new LinkedList<>());
            edges.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < n; i++)
            if (!ok[i] && !dfs(i)) return false;
        return true;
    }
    
    private boolean dfs(int x) {
        if (!edges.containsKey(x)) return true;
        for (Integer next: edges.get(x)) {
            if (vis[next]) return false;
            vis[next] = true;
            if (!dfs(next)) return false;
            vis[next] = false; ok[next] = true;
        }
        return true;
    }
}

// version 1, toposort O(n^2).
// i'm an idiot...
// class Solution {
//     
//     private boolean[] vis;
//     
//     public boolean canFinish(int numCourses, int[][] pre) {
//         Map<Integer, List<Integer>> edges = new HashMap<>();
//         int[] in = new int[numCourses];
//         vis = new boolean[numCourses];
//         
//         for (int i = 0 ; i < pre.length; i++) {
//             edges.computeIfAbsent(pre[i][1], x -> new LinkedList());
//             edges.get(pre[i][1]).add(pre[i][0]);
//             in[pre[i][0]]++;
//         }
//         
//         return sort(in, edges);
//     }
//     
//     private boolean sort(int[] in, Map<Integer, List<Integer>> edges) {
//         int cnt = 0;
//         while (cnt < in.length){
//             int i = 0;
//             while (i < vis.length && (vis[i] || in[i] != 0)) i++;
// 
//             if (i == in.length) return false;
//             cnt++;
//             vis[i] = true;
// 
//             if (edges.containsKey(i)) for (Integer next: edges.get(i))
//                 in[next]--;
//         }
//         return true;
//     }
// }

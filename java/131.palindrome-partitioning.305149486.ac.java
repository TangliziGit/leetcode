class Solution {
    private boolean[][] seg;
    private int n;
    private String s;
    private List<List<String>> ans;
    
    public List<List<String>> partition(String s) {
        this.s = s;
        this.n = s.length();
        this.seg = new boolean[n][n];
        this.ans = new ArrayList<>();
        
        for (int y = 0; y < n; y++)
            for (int x = y; x >= 0; x--)
                seg[x][y] = (s.charAt(x) == s.charAt(y)) && (x+1>=y-1 || seg[x+1][y-1]);
            
        solve(new LinkedList<>(), 0);
        return ans;
    }
    
    private void solve(LinkedList<String> path, int pos) {
        if (pos == n) {
            ans.add(new ArrayList(path));
        } else for (int i = pos; i < n; i++) if (seg[pos][i]) {
            path.add(s.substring(pos, i+1));
            solve(path, i+1);
            path.removeLast();
        }
    }
}

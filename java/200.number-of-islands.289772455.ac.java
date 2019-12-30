class Solution {
    
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] map;
    private char[][] grid;
    
    public int numIslands(char[][] grid) {
        if (null == grid || 0 == grid.length || 0 == grid[0].length) return 0;
        this.map = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        int cnt = 0;
        
        for (int y = 0; y < grid.length; y++)
            for (int x = 0; x < grid[0].length; x++)
                if (grid[y][x] == '1' && !map[y][x]){
                    dfs(y, x);
                    cnt++;
                }
        return cnt;
    }
    
    private void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int xx = x + dirs[i][0], yy = y + dirs[i][1];
            
            if (xx<0 || xx>=map[0].length || yy<0 || yy>=map.length)
                continue;
            if (grid[yy][xx] == '0') continue;
            if (map[yy][xx]) continue;
            map[yy][xx] = true;
            dfs(yy, xx);
        }
    }
}

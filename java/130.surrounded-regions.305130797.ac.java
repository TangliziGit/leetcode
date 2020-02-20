class Solution {
    
    private final int[] dir = new int[]{1,0, 0,1, -1,0, 0,-1};
    private char[][] board;
    private boolean[][] vis;
    private boolean[][] checked;
    private boolean[][] pass;
    private int nx, ny;
    
    public void solve(char[][] board) {
        if (null == board || board.length == 0) return;
        this.board = board;
        this.nx = board[0].length;
        this.ny = board.length;
        this.vis = new boolean[ny][nx];
        this.pass = new boolean[ny][nx];
        this.checked = new boolean[ny][nx];
        
        for (int y = 0; y < ny; y++)
            for (int x = 0; x < nx; x++) if (board[y][x] == 'O'){
                if (vis[y][x]) continue;
                if (check(x, y))
                    fill(x, y);
                else unfill(x, y);
            }
    }
    
    private boolean check(int x, int y) {
        if (checked[y][x]) return pass[y][x];
        checked[y][x] = true;
        pass[y][x] = true;
        for (int i = 0; i < 4; i++){
            int xx = x + dir[2*i], yy = y + dir[2*i+1];
            
            if (xx < 0 || yy < 0 || xx >= nx || yy >= ny)
                return pass[y][x] = false;
            if (board[yy][xx] == 'X') continue;
            
            if (!(pass[y][x] &= check(xx, yy)))
                break;
        }
        return pass[y][x];
    }
    
    private void fill(int x, int y) { 
        board[y][x] = 'X';
        for (int i = 0; i < 4; i++){
            int xx = x + dir[2*i], yy = y + dir[2*i+1];
            
            if (xx < 0 || yy < 0 || xx >= nx || yy >= ny) continue;
            if (board[yy][xx] == 'X') continue;
            fill(xx, yy);
        }
    }
    
    private void unfill(int x, int y) {
        vis[y][x] = true;
        for (int i = 0; i < 4; i++){
            int xx = x + dir[2*i], yy = y + dir[2*i+1];
            
            if (xx < 0 || yy < 0 || xx >= nx || yy >= ny) continue;
            if (board[yy][xx] == 'X') continue;
            if (vis[yy][xx]) continue;
            unfill(xx, yy);
        }
    }
}

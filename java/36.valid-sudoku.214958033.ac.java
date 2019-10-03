class Solution {
    private char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board=board;
        for (int y=0; y<board.length; y++)
            if (!checkRow(y)) return false;
        for (int x=0; x<board.length; x++)
            if (!checkCol(x)) return false;
        for (int y=0; y<3; y++)
            for (int x=0; x<3; x++)
                if (!checkBlock(x*3, y*3))
                    return false;
        return true;
    }
    
    private boolean checkRow(int y){
        boolean[] vis=new boolean[9];
        for (int i=0; i<9; i++)
            if (board[y][i]!='.'){
                int ch=board[y][i]-'1';
                if (vis[ch]) return false;
                vis[ch]=true;
            }
        return true;
    }
    
    private boolean checkCol(int x){
        boolean[] vis=new boolean[9];
        for (int i=0; i<9; i++)
            if (board[i][x]!='.'){
                int ch=board[i][x]-'1';
                if (vis[ch]) return false;
                vis[ch]=true;
            }
        return true;
    }
    
    private boolean checkBlock(int x, int y){
        boolean[] vis=new boolean[9];
        for (int i=0; i<9; i++)
            if (board[y+i/3][x+i%3]!='.'){
                int ch=board[y+i/3][x+i%3]-'1';
                if (vis[ch]) return false;
                vis[ch]=true;
            }
        return true;
    }
}

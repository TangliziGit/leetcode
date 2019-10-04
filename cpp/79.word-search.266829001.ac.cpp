class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if (board.size() == 0) return false;
        memset(vis, false, sizeof(vis));
        for (int y=0; y<board.size(); y++)
            for (int x=0; x<board[y].size(); x++) if (board[y][x]==word[0]){
                vis[y][x]=true;
                if (dfs(x, y, 1, word, board)) return true;
                vis[y][x]=false;
            }
        return false;
    }
    
    bool dfs(int x, int y, int idx, string &w, vector<vector<char>>& board){
        if (idx==w.size()) return true;
        for (int i=0; i<4; i++){
            int xx=x+dir[i][0], yy=y+dir[i][1];
            
            if (yy<0 || xx<0 || yy>=board.size() || xx>=board[0].size()) continue;
            if (vis[yy][xx]) continue;
            if (board[yy][xx]!=w[idx]) continue;
            vis[yy][xx]=true;
            if (dfs(xx, yy, idx+1, w, board)) return true;
            vis[yy][xx]=false;
        }return false;
    }
private:
    int vis[200][200];
    int dir[4][2]={1, 0, 0, 1, -1, 0, 0, -1};
};

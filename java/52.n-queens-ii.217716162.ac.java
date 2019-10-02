class Solution {
    private boolean[][] vis;
    private int n;

    public int totalNQueens(int n) {
        this.n=n;
        vis=new boolean[3][2*n-1];
        return solve(0);
    }

    private int solve(int dep){
        if (dep==n) return 1;

        int sum=0;
        for (int i=0; i<n; i++){
            if (vis[0][i] || vis[1][dep+i] || vis[2][dep-i+n-1]) continue;

            vis[0][i]=vis[1][dep+i]=vis[2][dep-i+n-1]=true;
            sum+=solve(dep+1);
            vis[0][i]=vis[1][dep+i]=vis[2][dep-i+n-1]=false;
        }return sum;
    }
}



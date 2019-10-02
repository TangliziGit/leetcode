class Solution {
    private List<List<String>> ans;
    private boolean[][] vis;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        ans=new LinkedList();
        vis=new boolean[3][2*n-1];
        solve(0, new LinkedList());
        return ans;
    }

    private void solve(int dep, LinkedList<String> lis){
        if (dep==n){
            ans.add((List<String>)lis.clone());
            return;
        }

        for (int i=0; i<n; i++){
            if (vis[0][i] || vis[1][dep+i] || vis[2][dep-i+n-1]) continue;

            vis[0][i]=vis[1][dep+i]=vis[2][dep-i+n-1]=true;
            lis.offerLast(createString(i));
            solve(dep+1, lis);
            lis.removeLast();
            vis[0][i]=vis[1][dep+i]=vis[2][dep-i+n-1]=false;
        }
    }

    private String createString(int i){
        StringBuilder builder=new StringBuilder("");
        for (int _i=0; _i<n; _i++)
            if (_i==i) builder.append("Q");
            else builder.append(".");
        return builder.toString();
    }
}


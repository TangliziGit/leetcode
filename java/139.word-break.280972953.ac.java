// need to be optimized
// now is O(n^3), if using triTree, it will be O(n)~O(n^2).
class Solution {
    private Boolean[] dp;
    private List<String> words;
    private String target;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if (null == s || s.length()==0) return true;
        this.dp = new Boolean[s.length()+5];
        this.words = wordDict;
        this.target = s;
        
        return solve(s.length());
    }
    
    private boolean solve(int x) {
        if (x == 0) return true;
        if (null != dp[x]) return dp[x];
        
        dp[x] = false;
        for (String word: words) {
            int len = word.length();
            if (x >= len && word.equals(target.substring(x - len, x)))
                dp[x] |= solve(x - len);
        }
        return dp[x];
    }
}

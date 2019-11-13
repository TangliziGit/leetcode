/*
1. new ArrayList<>(Collections.nCopies(100, null))
    instead of new ArrayList<>(100);

*/

// need to optimize, using a triTree
class Solution {
    private List<List<StringBuilder>> dp;
    private List<String> words;
    private String target;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (null == s || s.length() == 0) return Arrays.asList("");
        this.dp = new ArrayList<>(Collections.nCopies(s.length()+5, null));
        this.words = wordDict;
        this.target = s;
        
        List<String> ans = new ArrayList<>();
        for (StringBuilder builder: solve(s.length()))
            ans.add(builder.deleteCharAt(builder.length()-1).toString());
        return ans;
    }
    
    private List<StringBuilder> solve(int x) {
        if (x == 0) return new ArrayList<>(Arrays.asList(new StringBuilder()));
        if (null != dp.get(x)) return dp.get(x);
        
        dp.set(x, new ArrayList<>());
        for (String word: words) {
            int len = word.length();
            if (x >= len && word.equals(target.substring(x - len, x))) {
                for (StringBuilder builder: solve(x - len)) {
                    dp.get(x).add(new StringBuilder(builder).append(word).append(" "));
                }
            }
        }
        return dp.get(x);
    }
}

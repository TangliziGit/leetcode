class Solution {
    private static List<Set<String>> dp=new ArrayList(100);
    static {
        Set<String> tmp=new HashSet();
        tmp.add("()");
        dp.add(0, tmp);
    }
    
    public List<String> generateParenthesis(int n) {
        return new LinkedList<String>(solve(n));
    }
    
    private Set<String> solve(int n){
        if (dp.size()>n-1) return dp.get(n-1);
        Set<String> res=new HashSet();
        for (String str: solve(n-1))
            res.add("("+str+")");
        
        for (int i=1; i<=n-i; i++){
            for (String str1: solve(i))
                for (String str2: solve(n-i)){
                    if (i!=n-i) res.add(str1+str2);
                    res.add(str2+str1);
                }
        }
        dp.add(n-1, res);
        return res;
    }
}


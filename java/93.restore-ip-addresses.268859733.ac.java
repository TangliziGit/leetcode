class Solution {
    private List<List<Integer>> spliters = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12) return new LinkedList<>();
        solve(s, 0, new LinkedList<>());
        
        List<String> ans = new LinkedList<>();
        for (List<Integer> spliter: spliters){
            StringBuilder builder = new StringBuilder(s);
            ListIterator<Integer> it = spliter.listIterator(spliter.size()-1);
            while (it.hasPrevious())
                builder.insert(it.previous()+1, ".");
            ans.add(builder.toString());
        }
        return ans;
    }
    
    private void solve(String s, int idx, LinkedList<Integer> path){
        if (path.size()==4 && idx==s.length()) spliters.add(new LinkedList(path));
        for (int i=idx; i<s.length() && i<idx+3; i++){
            if (i!=idx && s.charAt(idx)=='0') continue;
            if (i==idx+2 && s.substring(idx, idx+3).compareTo("255")>0) continue;
            path.add(i);
            solve(s, i+1, path);
            path.removeLast();
        }
    }
}

// Stream version
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return "";
        int minlen=Stream.of(strs)
            .mapToInt(x -> x.length())
            .reduce(Integer::min)
            .getAsInt();
        int idx=Stream.iterate(0, x -> x+1)
            .limit(minlen)
            .filter(x -> check(strs, x))
            .findFirst()
            .orElse(minlen);
        
        return strs[0].substring(0, idx);
    }
    
    public boolean check(String[] strs, int idx){
        return Stream.of(strs)
            .anyMatch(x -> x.charAt(idx)!=strs[0].charAt(idx));
    }
}

// Original
class OriginalSolution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return "";
        int idx=0, minlen=strs[0].length();
        for (String str: strs)
            minlen=Math.min(minlen, str.length());
        for (;idx<minlen; idx++)
            if (check(strs, idx)) break;
        return strs[0].substring(0, idx);
    }
    
    public boolean check(String[] strs, int idx){
        for (String str: strs)
            if (str.charAt(idx)!=strs[0].charAt(idx))
                return true;
        return false;
    }
}

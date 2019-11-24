class Solution {
    private String a, b;
    private Boolean[][] dp;

    public boolean isScramble(String s1, String s2) {
        if (null == s1 || null == s2 || s1.length()!=s2.length()) return false;
        return solve(s1, s2);
    }
     
    private boolean solve(String s1, String s2) {
        if (s1.length() == 1) return s1.equals(s2);
        
        int[] map1 = new int[26], map2 = new int[26];
        for (int i = 0, cnt1 = 0, cnt2 = 0; i < s1.length()-1; i++) {
            if (map1[s1.charAt(i) - 'a']++ < 0) cnt1++;
            if (map1[s2.charAt(i) - 'a']-- > 0) cnt1++;
            
            if (cnt1 == i+1 && solve(s1.substring(0, cnt1), s2.substring(0, cnt1)) && 
                solve(s1.substring(cnt1), s2.substring(cnt1))) return true;
            
            if (map2[s1.charAt(i) - 'a']++ < 0) cnt2++;
            if (map2[s2.charAt(s1.length()-1-i) - 'a']-- > 0) cnt2++;
            
            if (cnt2 == i+1 && solve(s1.substring(0, cnt2), s2.substring(s1.length()-cnt2)) &&
                solve(s1.substring(cnt2), s2.substring(0, s1.length()-cnt2))) return true;
        }
        return false;
    }
}

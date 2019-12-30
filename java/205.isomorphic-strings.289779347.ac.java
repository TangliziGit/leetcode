class Solution {
    public boolean isIsomorphic(String s, String t) {
        return s.length() == t.length() && transform(s).equals(transform(t));
    }
    
    private String transform(String s) {
        char next = 'a';
        char[] map = new char[128];
        StringBuilder builder = new StringBuilder();
        
        for (char ch: s.toCharArray()) {
            int idx = ch;
            if (map[idx] == 0) map[idx] = next++;
            builder.append(map[idx]);
        }
        return builder.toString();
    }
}

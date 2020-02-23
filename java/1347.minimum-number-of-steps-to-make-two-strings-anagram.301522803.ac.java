class Solution {
    public int minSteps(String s, String t) {
        Map<Integer, Integer> chars = new HashMap<>();
        
        for (int i = 0; i<s.length(); i++){
            int ch = s.charAt(i);
            if (!chars.containsKey(ch)) chars.put(ch, 0);
            chars.put(ch, chars.get(ch)+1);
        }
        
        int cnt = 0;
        for (int i = 0; i<t.length(); i++){
            int ch = t.charAt(i);
            if (chars.containsKey(ch) && chars.get(ch)>0)
                chars.put(ch, chars.get(ch)-1);
            else cnt++;
        }
        
        return cnt;
    }
}

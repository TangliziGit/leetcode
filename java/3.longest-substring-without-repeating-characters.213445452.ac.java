class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map=new int[128];
        int pre=0, pos=0, maxlen=0, len=s.length();
        
        Arrays.fill(map, -1);
        for (int i=0; i<len; i++){
            char ch=s.charAt(i);
            if (map[ch]>=pos) pos=map[ch]+1;
            map[ch]=i;
            
            pre++;
            maxlen=Math.max(maxlen, pre-pos);
        }return maxlen;
    }
}

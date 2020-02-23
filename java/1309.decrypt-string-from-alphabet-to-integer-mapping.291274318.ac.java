class Solution {
    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            if (i+2 >= s.length()) 
                builder.append((char)(s.charAt(i)-'1'+'a'));
            else {
                if (s.charAt(i+2)=='#') {
                    builder.append((char)((s.charAt(i)-'0')*10+s.charAt(i+1)-'1'+'a'));
                    i += 2;
                } else 
                    builder.append((char)(s.charAt(i)-'1'+'a'));
            }
        }
        return builder.toString();
    }
}

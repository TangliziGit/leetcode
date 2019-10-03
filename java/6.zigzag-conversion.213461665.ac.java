class Solution {
    public String convert(String s, int numRows) {
        StringBuilder ans=new StringBuilder("");
        int len=s.length();
        if (numRows==1) return s;
        
        for (int x=0; x<len; x+=2*numRows-2)
            ans.append(s.charAt(x));
        for (int y=1; y<numRows-1; y++)
            for (int x=0; x+y<len; x+=2*numRows-2){
                ans.append(s.charAt(x+y));
                if (x+y +2*numRows-2-2*y<len)
                    ans.append(s.charAt(x+y +2*numRows-2-2*y));
            }
        for (int x=numRows-1; x<len; x+=2*numRows-2)
            ans.append(s.charAt(x));
        
        return ans.toString();
    }
}

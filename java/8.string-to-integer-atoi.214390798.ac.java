class Solution {
    public int myAtoi(String str) {
        int sign=1, i=0, ans=0;
        str = str.trim();
        if (str.isEmpty()) return 0;
        else if (str.charAt(i)=='+') i++;
        else if (str.charAt(i)=='-') {i++; sign=-1;}

        while (i<str.length() && Character.isDigit(str.charAt(i))) {
            int ch=str.charAt(i)-'0';
            if (ans>(Integer.MAX_VALUE-ch)/10)
                return sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            ans=ans*10+ch;
            i++;
        }
        return sign*ans;
    }
}

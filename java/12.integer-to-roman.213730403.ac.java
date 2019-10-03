class Solution {
    private static String ans[]=new String[(int)4e3];
    private static Integer[] value={
        1, 4, 5, 9, 10,
        40, 50, 90, 100,
        400, 500, 900, 1000};
    private static String[] expr={
        "I", "IV", "V", "IX", "X",
        "XL", "L", "XC", "C",
        "CD", "D", "CM", "M"};
    
    public String intToRoman(int num) {
        return solve(num, value.length-1);
    }

    public String solve(int n, int ptr){
        if (ptr==-1) return "";
        if (ans[n]!=null) return ans[n];
        ans[n]=repeat(expr[ptr], n/value[ptr])+
            solve(n%value[ptr], ptr-1);
        return ans[n];
    }
    
    public String repeat(String s, int n){
        return new String(new char[n]).replace("\0", s);
    }
}

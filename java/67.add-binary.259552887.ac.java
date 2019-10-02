class Solution {
    public static String a, b;
    public static int ci;
    public String addBinary(String a, String b) {
        if (a==null || b==null || (a.length()==0 && b.length()==0)) return "0";
        this.a=new StringBuilder(a).reverse().toString();
        this.b=new StringBuilder(b).reverse().toString(); this.ci=0;
        int len=Math.max(a.length(), b.length());
        StringBuilder ans=new StringBuilder();
        
        for (int i=0; i<len; i++)
            ans.append(add(i));
        if (ci==1) ans.append("1");
        return ans.reverse().toString();
    }
    
    public static String add(int i){
        int ai=0, bi=0;
        if (i<a.length()) ai=a.charAt(i)-'0';
        if (i<b.length()) bi=b.charAt(i)-'0';
        
        int ti=ci;
        if (ai+bi+ci>=2) ci=1;
        else ci=0;
        return new Integer((ai+bi+ti)%2).toString();
    }
}

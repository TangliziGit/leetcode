class Solution {
    public String countAndSay(int n) {
        return solve("1", n-1);
    }
    
    private String solve(String str, int n){
        if (n==0) return str;
        StringBuilder builder=new StringBuilder("");
        int len=str.length();
        
        for (int i=0; i<len; i++){
            int count=1;
            while (i+1<len && str.charAt(i)==str.charAt(i+1)){
                i++; count++;
            }   
            builder.append(""+count+str.charAt(i));
        }
        return solve(builder.toString(), n-1);
    }
}

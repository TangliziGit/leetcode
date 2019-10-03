// class Solution {
//     public String longestPalindrome(String s) {
//         if (s==null || s.length()==0) return "";
//         int start=0, end=0;
//         for (int i=0; i<s.length(); i++){
//             int len=Math.max(
//                 check(i, i, s),
//                 check(i, i+1, s)
//             );
            
//             if (end-start<len){
//                 start=i-(len-1)/2;
//                 end=i+len/2;
//             }
//         }
        
//         return s.substring(start, end+1);
//     }
    
//     private int check(int i, int j, String s){
//         while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
//             i--; j++;
//         }return j-i-1;
//     }
// }

class Solution {
    private char[] str;
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return "";
        return manacher(s);
    }
    
    public String manacher(String s){
        str=new char[2*s.length()+5];
        str[0]='#';
        for (int i=0; i<s.length(); i++){
            str[(i<<1)+1]=s.charAt(i);
            str[(i<<1)+2]='#';
        }
        
        int n=2*s.length()+1;
        int mr=-1, mid=-1, maxRad=0, maxRadIdx=0;
        int[] rad=new int[str.length];
        for (int i=0; i<str.length; i++){
            if (mr>i) rad[i]=Math.min(rad[2*mid-i], mr-i);
            else rad[i]=1;
            
            while (i-rad[i]>=0 && i+rad[i]<n && str[i+rad[i]]==str[i-rad[i]]) rad[i]++;
            if (rad[i]+i>mr){
                mr=rad[i]+i; mid=i;
            }
            if (maxRad<rad[i]){
                maxRad=rad[i]; maxRadIdx=i;
            }
        }
        
        if (maxRadIdx%2==1)
            return s.substring(maxRadIdx/2-(maxRad/2-1), maxRadIdx/2+(maxRad/2-1)+1);
        else return s.substring((maxRadIdx/2-1)-(maxRad/2-1), maxRadIdx/2+(maxRad/2-1)+1);
    }
}

// 1. s==null || s.length()==0

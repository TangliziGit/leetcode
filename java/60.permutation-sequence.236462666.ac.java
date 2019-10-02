class Solution {
    private int[] fact=new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
    
    public String getPermutation(int n, int k) {
        String s="123456789";
        String res="";
        k--;
        
        while (n --> 0){
            int idx=k/fact[n];
            k%=fact[n];
            res+=s.charAt(idx);
            s=removeCharAt(s, idx);
        }
        return res;
    }
    
    private String removeCharAt(String s, int idx){
        return s.substring(0, idx) + s.substring(idx+1);
    }
}

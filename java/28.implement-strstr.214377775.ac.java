class Solution {
    private String tex, pat;
    private int[] fail;
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;
        tex=haystack; pat=needle;
        
        int tlen=tex.length(), plen=pat.length();
        getFail(plen);
        for (int i=0, j=0; i<tlen; i++){
            while (j!=0 && pat.charAt(j)!=tex.charAt(i)) j=fail[j];
            if (pat.charAt(j)==tex.charAt(i)) j++;
            if (j==plen) return i-plen+1;
        }return -1;
    }
    
    private void getFail(int plen){
        fail=new int[plen+1];
        fail[0]=fail[1]=0;
        for (int i=1; i<plen; i++){
            int j=fail[i];
            while (j!=0 && pat.charAt(i)!=pat.charAt(j)) j=fail[j];
            if (pat.charAt(i)==pat.charAt(j)) 
                fail[i+1]=j+1;
            else
                fail[i+1]=0;
        }
    }
}

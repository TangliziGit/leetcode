class Solution {
    public String minWindow(String s, String t) {
        int[] charSet = new int[200];
        int[] charSetT = new int[200];
        int charCntT=0;
        for (int i=0; i<t.length(); i++){
            charSetT[t.charAt(i)-'A']++; charCntT++;
        }
        
        int pre=0, pos=0, cnt=0;
        int prea=-1, posa=-1;
        for (; pos<s.length(); pos++){
            if (charSet[s.charAt(pos)-'A'] < charSetT[s.charAt(pos)-'A']) cnt++;
            charSet[s.charAt(pos)-'A']++;
            while (pre<pos && (charSetT[s.charAt(pre)-'A']==0 || charSet[s.charAt(pre)-'A']>charSetT[s.charAt(pre)-'A'])){
                charSet[s.charAt(pre)-'A']--;
                pre++;
            }
            
            if (cnt==charCntT && (pos-pre<posa-prea || prea==-1)){
                prea=pre; posa=pos; 
            }
        }
        
        if (prea==-1) return "";
        return s.substring(prea, posa+1);
    }
}

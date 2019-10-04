class Solution {
public:
    string minWindow(string s, string t) {
        int chars[130], Tchars[130], chcnt=0;
        memset(Tchars, 0, sizeof(Tchars));
        for (int i=0; i<t.length(); i++){
            Tchars[t[i]-'A']++; chcnt++;
        }
        memset(chars, 0, sizeof(chars));
        
        int pre=0, pos=0, cnt=0;
        int prea=-1, posa=-1;
        for (; pos<s.length(); pos++){
            if (chars[s[pos]-'A'] < Tchars[s[pos]-'A']) cnt++;
            chars[s[pos]-'A']++;
            while (pre<pos && (!Tchars[s[pre]-'A'] || chars[s[pre]-'A']>Tchars[s[pre]-'A'])){
                chars[s[pre]-'A']--;
                pre++;
            }
            
            if (cnt==chcnt && (pos-pre<posa-prea || prea==-1)){
                prea=pre; posa=pos; 
            }
        }
        
        // printf("per%d pos%d\n", prea, posa);
        // printf("cnt%d chcnt%d\n", cnt, chcnt);
        if (prea==-1) return "";
        return s.substr(prea, posa-prea+1);
    }
};

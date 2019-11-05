class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length(), i = 0, j = len - 1;
        
        s = s.toLowerCase();
        while (i<j){
            while (i<len && !checkCharactor(s.charAt(i))) i++;
            while (j>0 && !checkCharactor(s.charAt(j))) j--;
            if (i<j && s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
    
    private boolean checkCharactor(char ch){
        if ('a' <= ch && ch <= 'z') return true;
        if ('0' <= ch && ch <= '9') return true;
        return false;
    }
}

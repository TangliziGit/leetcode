class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Long> set = new HashSet<>();
        
        int cntZero = 0;
        for (int i = 0; i< arr.length; i++){
            if (arr[i] == 0) cntZero++;
            set.add(1l*arr[i]);
        }
        
        if (cntZero>=2) return true;
        for (int i = 0; i< arr.length; i++)
            if (arr[i] != 0 && set.contains(2l*arr[i])) return true;
        
        return false;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder ori=new StringBuilder(String.valueOf(x));
        ori.reverse();
        return ori.toString().equals(String.valueOf(x));
    }
}

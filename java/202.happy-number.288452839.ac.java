class Solution {
    public boolean isHappy(int n) {
        Set<Integer> vis = new HashSet<>();
        while ((n = next(n))!=1 && !vis.contains(n))
            vis.add(n);
        return n == 1;
    }
    
    private int next(int x){
        int next = 0;
        while (x>0) {
            next += (x%10)*(x%10);
            x /= 10;
        }
        return next;
    }
}

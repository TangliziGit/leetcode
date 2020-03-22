class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int x: nums)  
            sum += helper(x);
        return sum;
    }
    
    private int helper(int x) {
        int cnt = 0, sum = 0;
        int end = (int)Math.sqrt(x);
        for (int i=1; i<=end+1; i++){
            if (x%i==0) {
                if (i < x/i) {cnt+=2; sum+=i+x/i;}// System.out.println(i);System.out.println(x/i);}
                else if (i == x/i) {cnt++; sum+=i;}
            }
            if (cnt>4) return 0;
        }
        return cnt == 4?sum:0;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        
        int ans = 0;
        for (int i=prices.length-1; i>0; i--)
            if (prices[i]>prices[i-1]) ans += prices[i] - prices[i-1];
        return ans;
    }
}

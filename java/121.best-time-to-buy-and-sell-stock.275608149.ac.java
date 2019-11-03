class Solution {
    private int[] minlis, maxlis;
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        this.minlis = new int[prices.length];
        this.maxlis = new int[prices.length];
        minlis[0] = prices[0];
        for (int i = 1; i < prices.length; i++)
            minlis[i] = Math.min(minlis[i-1], prices[i]);
        
        maxlis[prices.length-1] = prices[prices.length-1];
        for (int i = prices.length - 2; i>=0; i--)
            maxlis[i] = Math.max(maxlis[i+1], prices[i]);
        
        int ans = 0;
        for (int i = 0; i < prices.length; i++)
            ans = Math.max(ans, maxlis[i] - minlis[i]);
        return ans;
    }
}

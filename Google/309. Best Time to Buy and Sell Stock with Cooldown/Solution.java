class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0; 
        
        int[] sell = new int[prices.length];
        int[] rest = new int[prices.length];
        
        // Set the initial table
        sell[0] = 0;
        sell[1] = Math.max(prices[1] - prices[0], 0);
        
        // temp variables
        int profit = 0;
        
        for(int i = 2; i < prices.length; i++){
            profit = prices[i] - prices[i-1];
            sell[i] = Math.max(Math.max(sell[i-1], rest[i-2]) + profit, 0);
            rest[i] = Math.max(sell[i-1], rest[i-1]);
        }
        
        return Math.max(sell[prices.length - 1], rest[prices.length - 1]);
    }
}
class Solution {
    
    // Method 1: One pass
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min_price)
                min_price = prices[i];
            else if(prices[i] - min_price > max_profit)
                max_profit = prices[i] - min_price;
        }
        
        return max_profit;
    }
}
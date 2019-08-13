class Solution {
    
    // Dynamic Programming -> Top Down
//     public int coinChange(int[] coins, int amount) {
        
//         if(amount <= 0)
//             return 0;
//         else if(coins == null || coins.length == 0)
//             return -1;
        
//         return utilCoinChange(coins, amount, new int[amount + 1]);   
//     }
    
    
//     private int utilCoinChange(int[] coins, int amount, int[] dp){
//         if(amount < 0)
//             return -1;
//         else if(amount == 0)
//             return 0;
        
//         if(dp[amount] != 0)
//             return dp[amount];
        
//         int min = Integer.MAX_VALUE;
        
//         int inner_result = -1;
        
//         for(int coin: coins){
//             inner_result = utilCoinChange(coins, amount - coin, dp);
            
//             min = (inner_result >= 0 && inner_result < min) ? 1 + inner_result : min;
//         }
        
//         dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        
        
//         return dp[amount];
//     }
    
    
    // Dynamic Programming -> Botton up
    public int coinChange(int[] coins, int amount) {
        
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
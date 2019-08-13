class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length + 2][piles.length + 2];
        
        for(int k = 1; k <= piles.length; k++){
            for(int i = 0; i + k <= piles.length; i++){
                
                int j = i + k - 1;
                int flag = (j+i+piles.length) % 2;
                
                if(flag == 1){
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
                }
                else{
                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
                }
            }
        }
        return (dp[1][piles.length] > 0);
    }
}
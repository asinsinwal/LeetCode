class Solution {
    
    // Method: Implementing DP in top-down
    public int maxCoins(int[] nums) {
        // set new array
        int[] nums_revised = new int[nums.length + 2];
        
        for(int i = 0; i < nums.length; i++)
            nums_revised[i+1] = nums[i];
        
        // set ends equal to 1
        nums_revised[0] = nums_revised[nums_revised.length - 1] = 1;
            
        // Define dp table
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        
        return getMaxCoins(dp, nums_revised, 0, nums.length + 1);
    }
    
    private int getMaxCoins(int[][] dp,  int[] nums, int left, int right) {
        // no more elements can be added
        if((left+1) == right)
            return 0;
        
        // if dynamic table has the answer
        if(dp[left][right] > 0)
            return dp[left][right];
        
        // define result
        int result = 0;
        for(int i = left+1; i < right; i++)
            result = Math.max(result, nums[left]*nums[i]*nums[right] + getMaxCoins(dp, nums, left, i) + getMaxCoins(dp, nums, i, right));
        
        // store the result
        dp[left][right] = result;
        
        return result;
    }
}
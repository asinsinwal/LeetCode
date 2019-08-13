class Solution {
    
    // Method 1: Greedy Approach
//     public int maxSubArray(int[] nums) {
        
//         int local_sum = nums[0], global_sum = nums[0];
        
//         for(int i = 1; i < nums.length; i++){
//             local_sum = Math.max(nums[i], local_sum + nums[i]);
//             global_sum = Math.max(global_sum, local_sum);
//         }
        
//         return global_sum;
//     }
    
    
    // Method 2: Divide and Conquer
    public int maxSubArray(int[] nums) {
        return utilMaxArray(nums, 0, nums.length-1);
    }
    
    private int utilMaxArray(int[] nums, int start, int end){
        if(start == end)
            return nums[start];
        
        int partition = (start+end)/2;
        
        int left_total = utilMaxArray(nums, start, partition);
        int right_total = utilMaxArray(nums, partition+1, end);
        int total_sum = merge(nums, start, end, partition);
        
        return Math.max(Math.max(left_total, right_total), total_sum);
    }
    
    private int merge(int[] nums, int start, int end, int part){
        if(start == end)
            return nums[start];
        
        int subtotal_left = Integer.MIN_VALUE;
        int running_left = 0;
        
        for(int i = part; i >= start; i--){
            running_left += nums[i];
            subtotal_left = Math.max(subtotal_left, running_left);
        }
        
        int subtotal_right = Integer.MIN_VALUE;
        int running_right = 0;
        
        for(int i = part+1; i <= end; i++){
            running_right += nums[i];
            subtotal_right = Math.max(subtotal_right, running_right);
        }
        
        return subtotal_left + subtotal_right;
    }
}
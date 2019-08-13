class Solution {
    
    //Method: Two pointers
    public int removeDuplicates(int[] nums) {
        //Step 1: Edge case
        if(nums == null || nums.length == 0)
            return 0;
        
        //Step 2: Define Variable
        int index = 0, current = Integer.MIN_VALUE;
        
        //Step 3: Iterate through array
        for(int i = 0; i < nums.length; i++){
            if(current < nums[i]){
                //Step 4: Bring the unique value ahead
                nums[index] = nums[i];
                current = nums[i];
                index++;
            }
        }
        
        //Step 5: Return length
        return index;
    }
}
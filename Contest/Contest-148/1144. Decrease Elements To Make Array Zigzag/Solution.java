class Solution {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(utilZigzagMin(nums, 0),utilZigzagMin(nums, 1));
    }
    
    private int utilZigzagMin(int[] nums, int flag){
        int result = 0;
        
        if(flag == 1){
            for(int i = 1; i < nums.length; i=i+2){
                if(!(nums[i-1] > nums[i]))
                    result += (nums[i] - (nums[i-1]-1));
                if((i+1 < nums.length) && !(nums[i+1] > nums[i]))
                    result += (nums[i] - (nums[i+1]-1));
            }
        }else{
            for(int i = 1; i < nums.length; i=i+2){
                if(!(nums[i-1] < nums[i]))
                    result += (nums[i-1] - (nums[i]-1));
                if((i+1 < nums.length) && !(nums[i+1] < nums[i]))
                     result += (nums[i+1] - (nums[i]-1));
            }
        }
        System.out.println(result);
        return result;
    }
}

// Wrong Answer

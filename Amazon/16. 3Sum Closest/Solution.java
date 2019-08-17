class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int closest = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int ptr1 = i+1, ptr2 = nums.length - 1;
            
            while(ptr1 < ptr2){
                sum = nums[i] + nums[ptr1] + nums[ptr2];
                
                if(sum == target)
                    return target;
                
                if(sum < target)
                    ptr1++;
                else
                    ptr2--;
                
                int diff = Math.abs(target - sum);
                System.out.println("18\t" + sum + "\t" + diff + "\t" + (target - sum) + "\t" + min);
                
                if(diff < min){
                    min = diff;
                    closest = sum;
                }
            }
        }
        
        return closest;
    }
}
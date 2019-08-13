class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // variable for the loop
        int i = 0, temp = -1;
        
        // DS for result
        List<Integer> list = new ArrayList<>();
        
        while(i < nums.length){
            temp = nums[i];
            if(nums[i] == 0 || nums[i] == -1)
                i++;
            else{
                if(nums[i] == i+1)
                    nums[i++] = 0;
                else if(nums[temp-1] == 0){
                    nums[i++] = -1;
                }else{
                    temp = nums[i];

                    nums[i] = nums[temp-1];
                    nums[temp-1] = 0;
                }
            }
        }
        
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0)
                list.add(j+1);
        }
        
        return list;
    }
}
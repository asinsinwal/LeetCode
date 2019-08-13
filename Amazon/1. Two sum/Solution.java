class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //Step 1: Declare Map
        HashMap<Integer, Integer> search_map = new HashMap<>();
        int temp = -1;
        //Step 2: Iterate through array
        for(int i = 0; i < nums.length; i++){
            temp = target-nums[i];          //Step 3: Return if found
            if(search_map.containsKey(temp))
                return new int[]{search_map.get(temp), i};
            else                            //Step 4: Store into map
                search_map.put(nums[i], i);
        }
        //Step 5: Return [0,0] if not found
        return new int[] {0,0};
    }
}
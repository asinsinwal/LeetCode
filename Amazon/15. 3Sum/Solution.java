class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Two pointers problem
        //Step 1: Define the Data Structure needed 
        List<List<Integer>> triplets = new ArrayList<>();
        
        //Step 2: Define values
        int len = nums.length, sum = 0, j = -1, k = -1;
        
        //Step 3: Sort the i/p array
        Arrays.sort(nums);
        
        //Step 4: Iterate through the list
        for(int i = 0; i < len - 2; i++){
            //Step 4a: Check for i duplication
            if(i > 0){
                while(i < len - 2 && nums[i-1] == nums[i])
                    i++;    
            }
            
            j = i + 1;
            k = len - 1;
            
            //Find triplets
            while(j < k){
                //Step 5: Check for sum
                sum = nums[i] + nums[j] + nums[k];
                
                //Step 6: If sum = 0, add the triplet
                if(sum == 0){
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    //Step 7: Remove Duplications
                    while((j < k) && nums[j-1] == nums[j])
                        j++;
                    while((k > j) && nums[k+1] == nums[k])
                        k--;
                } else if(sum < 0)      //Step 8: If sum <> 0, handle the case
                    j++;
                else
                    k--;
            }
        }
        //Step 9: Return triplets
        return triplets;
    }
}
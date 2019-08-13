class Solution {
    //   public void backtrack(int n,
    //                         ArrayList<Integer> nums,
    //                         List<List<Integer>> output,
    //                         int first) {
    //     // if all integers are used up
    //     if (first == n)
    //       output.add(new ArrayList<Integer>(nums));
    //     for (int i = first; i < n; i++) {
    //       // place i-th integer first 
    //       // in the current permutation
    //       Collections.swap(nums, first, i);
    //       // use next integers to complete the permutations
    //       backtrack(n, nums, output, first + 1);
    //       // backtrack
    //       Collections.swap(nums, first, i);
    //     }
    //   }
    
    //   public List<List<Integer>> permute(int[] nums) {
    //     // init output list
    //     List<List<Integer>> output = new LinkedList();
    
    //     // convert nums into list since the output is a list of lists
    //     ArrayList<Integer> nums_lst = new ArrayList<Integer>();
    //     for (int num : nums)
    //       nums_lst.add(num);
    
    //     int n = nums.length;
    //     backtrack(n, nums_lst, output, 0);
    //     return output;
    //   }
        
        public List<List<Integer>> permute(int[] nums) {
          
          List<List<Integer>> result = new ArrayList<>();
          int[] count = new int[nums.length];
          int[] storage = new int[nums.length];
          Arrays.fill(count, 1);
          backtrack(nums, result, count, storage, 0);
          return result;
        }
        
        private void backtrack(int[] nums, List<List<Integer>> result, int[] count, int[] storage, int depth){
            if(depth == nums.length){
                List<Integer> curr_perm = new ArrayList<>();
                
                for(int element: storage)
                    curr_perm.add(element);
                
                result.add(curr_perm);
                return;
            }
            
            for(int i = 0; i < count.length; i++){
                if(count[i] != 0){
                    storage[depth] = nums[i];
                    count[i]--;
                    backtrack(nums, result, count, storage, depth + 1);
                    count[i]++;
                }
            }
        }
    }
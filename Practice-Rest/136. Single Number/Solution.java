class Solution {
    
    // Method 1
//     public int singleNumber(int[] nums) {
        
//         int result = 0;
        
//         for(int i = 0; i < nums.length; i++){
//             //XOR
//             result ^= nums[i];
//         }
        
//         return result;
//     }
    
    // Method 2 = Sum; 2*(a+b+c) - (a+a+b+b+c) = c
    public int singleNumber(int[] nums) {
        Set<Integer> unique = new HashSet<Integer>();
        for(int i: nums)
            unique.add(i);
        
    
        int sum = 0;
        
        Iterator<Integer> itr = unique.iterator();
        
        while(itr.hasNext()){
            sum += 2*(itr.next());
        }
        
        for(int i = 0; i < nums.length; i++){
            sum -= nums[i];
        }
        
        return sum;
    }
}
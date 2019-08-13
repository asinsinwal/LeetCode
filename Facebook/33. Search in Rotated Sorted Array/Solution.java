class Solution {
    // Method 1: Binary Search
    public int search(int[] nums, int target) {
        
        //Step 1: Edge case
        
        //Step 2: Define variables
        int low = 0, high = nums.length - 1, mid = 0;
        
        
        //Step 3: Loop into array
        while (low <= high){
            //Step 4: Check for rotated array and modify the binary search. Calculate mid
            mid = (low + high)/2;
        
            //Step 5: Termination condition
            if(nums[mid] == target)
                return mid;
            //Step 6: If mid value is greater than low value (normal sorted part)
            if(nums[low] < nums[mid]){
                if(nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }else if(nums[low] > nums[mid]){
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }else {
                low = mid + 1;
            }
            //Step 7: If mid value is less than low value (rotated between low and mid)
            //Step 8: If low == md
        }
        
        //Step 9: Return -1 (if nothing found)
        return -1;
    }
}
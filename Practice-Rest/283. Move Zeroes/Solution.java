class Solution {
    public void moveZeroes(int[] nums) {
        int ptr1 = 0, ptr2 = 0;
        
        while(ptr1 < nums.length && ptr2 < nums.length){
            if(nums[ptr1] == 0)
                ptr1++;
            else if(nums[ptr2] != 0)
                ptr2++;
            else{
                nums[ptr2++] = nums[ptr1];
                nums[ptr1++] = 0;
            }
        }
    }
}
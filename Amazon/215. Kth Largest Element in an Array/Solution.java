class Solution {
    
    // Method 1: Heap   -> Q(N(logk))
//     public int findKthLargest(int[] nums, int k) {
//         if(k > nums.length)
//             return -1;
        
//         // define data structure
//         PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1-n2);
        
//         // we just have to keep k elements inside the heap and remove smallest recursively 
//         for(int i: nums){
//             heap.add(i);
            
//             if(heap.size() > k)
//                 heap.poll();                // always removing all elements less than k
//         }
        
//         return heap.poll();                 // return kth element
//     }
    
    // Method 2: Quickselect -> from quicksort (Tony Hoare)
    Random rndm = new Random();
    
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length)
            return -1;
        
        return quickSelect(nums, 0, nums.length -1, nums.length - k);
    }
    
    
    private int quickSelect(int[] nums, int left, int right, int kth_smallest){
        if(left == right)
            return nums[left];
        
        int pivot_index = left + rndm.nextInt(right - left);
        
        pivot_index = actualPivotIndex(nums, left, right, pivot_index);
        
        if(pivot_index == kth_smallest)
            return nums[kth_smallest];
        else if(kth_smallest < pivot_index)
            return quickSelect(nums, left, pivot_index - 1, kth_smallest);
        else
            return quickSelect(nums, pivot_index + 1, right, kth_smallest);
    }
    
    private void swap(int[] nums, int ptr1, int ptr2){
        int temp = nums[ptr1];
        nums[ptr1] = nums[ptr2];
        nums[ptr2] = temp;
    }
    
    private int actualPivotIndex(int[] nums,int left,int right,int pivot_index){
        int pivot = nums[pivot_index];
        int current_index = left;
        
        swap(nums, pivot_index, right);
        
        
        for(int i = left; i <= right; i++){
            if(nums[i] < pivot){
                swap(nums, current_index, i);
                current_index++;
            }
        }
        
        swap(nums, current_index, right);
        
        return current_index;
        
    }
}
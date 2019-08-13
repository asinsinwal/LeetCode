class Solution {
//     public int trap(int[] height) {
//         //Method 1: Using stack
//         if(height == null || height.length == 0)
//             return 0;
        
//         //Declare variables
//         int index = 0, trapped = 0;
//         int valley = 0;
        
//         //Define stack
//         Stack<Integer> mystk = new Stack<>();
        
//         //Ignoring all 0 heighted bars
//         while(index < height.length && height[index] == 0)
//             index++;
        
//         for(int i = index; i < height.length; i++){
//             //check if valey created or if previous small bars are not worth staying in stack
//             while(!mystk.isEmpty() && height[i] > height[mystk.peek()]){
//                 valley = height[mystk.pop()];
//                 //Check if valley was created and update trap water
//                 if(!mystk.isEmpty())
//                     trapped += (Math.min(height[i], height[mystk.peek()]) - valley)*(i-mystk.peek()-1);
//             }
            
//             //push current value
//             mystk.push(i);
//         }
//         return trapped;
//     }
    
    //Method 2: Two pointers
    public int trap(int[] height) {
        if(height == null || height.length <= 1)
            return 0;
        
        //Declare variables
        int left = 0, right = height.length-1, highL = 0, highR = 0, trapped = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= highL)
                    highL = height[left];
                else
                    trapped += highL - height[left];
                left++;
            }else{
                if(height[right] >= highR)
                    highR = height[right];
                else
                    trapped += highR - height[right];
                right--;
            }
        }
        return trapped;
    }
}

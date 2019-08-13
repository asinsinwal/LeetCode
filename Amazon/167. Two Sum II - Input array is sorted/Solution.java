class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0, ptr2 = numbers.length - 1;
        int[] result = new int[2];
        
        while(ptr1 < ptr2){
            if(target - numbers[ptr1] < numbers[ptr2]){
                ptr2--;
            }else if(target - numbers[ptr1] > numbers[ptr2]){
                ptr1++;
            }else
                break;
        }
        
        result[0] = ptr1+1;
        result[1] = ptr2+1;
        
        return result; 
    }
}
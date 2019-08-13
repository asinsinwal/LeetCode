class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //Step 1: Define 2 pointers and result
        int result = 0, p1 = 0, p2 = 0;
        
        //Step 2: Define boolean for all characters range
        boolean[] check = new boolean[128];
        
        //Step 3: Iterate the string length
        while(p1 < s.length()){
            //Step 4: Edge case - if char found in the bool table, set the other pointer's value to false
            if(check[(int)s.charAt(p1)]){
                check[(int)s.charAt(p2++)] = false;
            }else{
                check[(int)s.charAt(p1++)] = true;
                result = Math.max(result, p1 - p2);
            }
            //Step 5: if char not found in the bool table, set the char found to true and count the difference between pointer
        }
        
        return Math.max(result, p1 - p2);
    }
}
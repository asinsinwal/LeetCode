class Solution {
    
    //Step 1: Final string of telephone buttons
    String[] tel_buttons = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        
        //Step 2: Define the data structure
        List<String> result = new ArrayList<>();
        
        //Step 3: Edge case
        if(digits == null || digits.length() == 0)
            return result;
        //Step 4: Caller backtracking function
        utilFunction(result, "", 0, digits);
        
        return result;
    }
    
    //Backtracking function to set the strings
    private void utilFunction(List<String> result, String comb, int index, String digits){
        //Step 4a: Edge case
        if(comb.length() == digits.length()){
            result.add(comb);
            return;
        }
        
        
        //Step 4b: Declare variables
        int digit = digits.charAt(index) - '0';
        String lookup = tel_buttons[digit];
        
        //Step 4c: Iterate through the list and call utilFunction
        for(int i = 0; i < lookup.length(); i++){
            utilFunction(result, comb.concat(String.valueOf(lookup.charAt(i))), index+1, digits);
        }
    }
}
class Solution {
    
    // Math multiplication formula 
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0)
            return "0";
        
        // Defing result table and result stringbuilder
        int[] res = new int[num1.length() + num2.length()];
        StringBuilder result = new StringBuilder("");
        int mul = 0, total_sum = 0;
        
        
        //2-D array, and set the values of each mulitplication
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                mul = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                total_sum = res[i+j+1] + mul;
                res[i + j] += total_sum / 10;
                res[i + j + 1] = total_sum % 10;   
            }
        }
        
        for(int val: res){
            if(!(result.length() == 0 && val == 0))
                result.append(val);
        }
        
        return (result.length() == 0) ? "0" : result.toString();   
    }
}
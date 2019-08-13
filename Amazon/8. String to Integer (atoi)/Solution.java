class Solution {
//     public int myAtoi(String str) {
        
//         //Step 0: Define variables
//         long result = 0;
//         int flag = 1;
//         //Step 1: Trim the string
//         str = str.trim();
        
//         //Step 2: Edge cases
//         if(str.length() == 0 || (str.length() == 1 && (str.charAt(0) == '-' || str.charAt(0) == '+')))
//             return 0;
        
//         //Step 3: Check if negative 
//         if(str.charAt(0) == '-'){
//             flag = -1;
//             str = str.substring(1);
//         }else if(str.charAt(0) == '+'){         //Step 4: Check if positive
//             flag = 1;
//             str = str.substring(1);
//         }
        
//         //Step 5: Get all the digits
//         for(int i = 0; i < str.length() && Character.isDigit(str.charAt(i)); i++){
//             result = result*10 + (str.charAt(i) - '0');
            
//             //Step 6: Check if value is less than INT_MIN
//             if(result*flag < Integer.MIN_VALUE)
//                 return Integer.MIN_VALUE;
//             //Step 7: Check if value is larger than INT_MAX
//             if(result*flag > Integer.MAX_VALUE)
//                 return Integer.MAX_VALUE;
//         }
//         //Step 8: Return appropriate result
//         return (int)result*flag;
//     }
    
    //Method 2
    public int myAtoi(String str) {
        
        char[] strtoarr = str.toCharArray();
        long result = 0;
        int i = 0, sign = 1;
        int len = strtoarr.length;
        
        //Clear whitespaces
        while(i < len){
            if(strtoarr[i] == ' ')
                i++;
            else
                break;
        }
        
        //Check for sign
        if(i < len && (strtoarr[i] == '-' || strtoarr[i] == '+'))
            sign = 1 - 2 * (strtoarr[i++] == '-'? 1: 0);
        
        
        while(i < len){
            if(strtoarr[i] >= '0' && strtoarr[i] <= '9'){
                result = result*10 + (strtoarr[i] - '0');
                System.out.println(result);
                if(result*sign < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                
                if(result*sign > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }else{
                break;
            }
            i++;
        }
        
        return (int)result*sign;
        
    }
}
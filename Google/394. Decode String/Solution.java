class Solution {
    
    // Method 1: DFS
//     public String decodeString(String s) {
//         // Define stringbuilder
//         StringBuilder result = new StringBuilder();
        
//         // Call depth first search (backtracking)
//         dfs(s, result, 0);
//         return result.toString();
//     }
    
//     private int dfs(String s, StringBuilder result, int index){
//         //Define variables
//         char c =  ' ';
//         // Loop into s.length()
//         while(index < s.length()){
//             c = s.charAt(index);
            
//             if(c == ']'){
//                 break;
//             }else if(c >= '0' && c <= '9'){
//                 int num = 0;
//                 while(c >= '0' && c <= '9'){
//                     num = num*10 + (c - '0');
//                     index++;
//                     c = s.charAt(index);
//                 }
//                 StringBuilder partial = new StringBuilder();
//                 index = dfs(s, partial, index);
                
//                 for(int i = 0; i < num; i++)
//                     result.append(partial);
                
//             }else if(c == '['){
//                 index++;
//                 continue;
//             }else {
//                 result.append(c);
//             }
//             index++;
//         }
        
//         return index;
//     }
    
    // Method 2: Stack
    public String decodeString(String s) {
        //Define stacks
        Stack<String> str_stk = new Stack<>();
        Stack<Integer> int_stk = new Stack<>();
        
        //Define String
        String result = "";
        int index = 0;
        char c = ' ';
        int num = 0;
        String temp = "";
        
        while(index < s.length()){
            c = s.charAt(index);
            
            if(c == ']'){
                num = int_stk.pop();
                temp = "";
                
                for(int i = 0; i < num; i++){
                    temp += result;
                }
                result = str_stk.isEmpty()? "" : str_stk.pop();
                result = result + temp;
            }else if(c >= '0' && c <= '9'){
                num = 0;
                while(c >= '0' && c <= '9'){
                    num = num*10 + (c - '0');
                    index++;
                    c = s.charAt(index);
                }
                int_stk.push(num);
                index--;
            }else if(c == '['){
                str_stk.push(result);
                result = "";
            }else{
                result += c;
            }
            index++;
        }
        
        return result;
    }
}
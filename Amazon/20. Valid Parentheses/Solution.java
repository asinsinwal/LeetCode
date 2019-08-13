class Solution {
//     public boolean isValid(String s) {
//         Map<Character,Character> brackets = new HashMap<>();
//         brackets.put('[',']');
//         brackets.put('{','}');
//         brackets.put('(',')');
        
//         Stack<Character> mystk = new Stack<>();
//         char temp;
        
//         for(int i = 0; i < s.length(); i++){
//             temp = s.charAt(i);
            
//             if(temp == '[' || temp == '{' || temp == '(')
//                 mystk.push(temp);
//             else if(mystk.isEmpty() || temp != brackets.get(mystk.pop()))
//                 return false;
//         }
        
//         return mystk.isEmpty();
//     }
    
    //Method 2
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Stack<Character> mystk = new Stack<>();
        
        for(int i = 0; i < str.length; i++){
            if(str[i] == '[' || str[i] == '{' || str[i] == '(')
                 mystk.push(str[i]);
            else{
                if(!mystk.isEmpty()){
                    if(str[i] == ')' && mystk.pop() == '(')
                        continue;
                    else if(str[i] == '}' && mystk.pop() == '{')
                        continue;
                    else if(str[i] == ']' && mystk.pop() == '[')
                        continue;
                    else
                        return false;
                }else
                    return false;
            }
        }
        return mystk.isEmpty();
    }
}
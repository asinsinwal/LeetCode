class Solution {
    //Method 1: Recursive in forward
//     public boolean isMatch(String s, String p) {
        
        
//         //Edge case
//         if(p.isEmpty())
//             return s.isEmpty();
        
//         //Define variable
//         boolean char_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        
//         //Define recursion
//         if(p.length() >= 2 && p.charAt(1) == '*'){
//             //When strings matches 1 or more characters OR it matches zero character
//             return char_match && isMatch(s.substring(1), p)
//                 || isMatch(s, p.substring(2));
//         }else{
//             //When first character is matched
//             return isMatch(s.substring(1), p.substring(1));
//         } 
//     }
    
    //Method 2: Recursive in reverse
//     public boolean isMatch(String s, String p) {
        
        
//         //Edge case
//         if(p.isEmpty())
//             return s.isEmpty();
        
//         //Define recursion
//         if(p.length() > 1 && p.charAt(p.length()-1) == '*'){
//             boolean char_match = !s.isEmpty() && (p.charAt(p.length()-2) == s.charAt(s.length()-1) || p.charAt(p.length()-2) == '.');
            
//             //When strings matches 1 or more characters OR it matches zero character
//             return char_match && isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()))
//                 || isMatch(s.substring(0,s.length()), p.substring(0, p.length()-2));
//         }else{
//             boolean char_match = !s.isEmpty() && (p.charAt(p.length()-1) == s.charAt(s.length()-1) || p.charAt(p.length()-1) == '.');
//             //When first character is matched
//             return char_match && isMatch(s.substring(0,s.length()-1), p.substring(0, p.length()-1));
//         } 
//     }
    
    //Method 3: DP (bottom up)
//     public boolean isMatch(String s, String p) {
        
//         boolean[][] d = new boolean[s.length()+1][p.length()+1];
//         d[s.length()][p.length()] = true;
        
//         boolean char_match = false;
//         //found the loop
//         for(int i = s.length(); i >= 0; i--){
//             for(int j = p.length()-1; j >= 0; j--){
//                 char_match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
//                 if(j+1 < p.length() && p.charAt(j+1) == '*'){
//                     d[i][j] = char_match && d[i+1][j] || d[i][j+2];
//                 }else{
//                     d[i][j] = char_match && d[i+1][j+1];
//                 }
//             }
//         }
//         return d[0][0];   
//     }
    
    //Method 4: DP (top down)
    public boolean isMatch(String s, String p) {
        
        boolean[][] d = new boolean[s.length()+1][p.length()+1];
        d[0][0] = true;
        
        boolean char_match = false;
        //found the loop
        for(int i = 0; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(j-1 >= 0 && p.charAt(j-1) == '*'){
                    char_match = i > 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.');
                    d[i][j] = char_match && d[i-1][j] || d[i][j-2];
                }else{
                    char_match = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                    d[i][j] = char_match && d[i-1][j-1];
                }
            }
        }
        return d[s.length()][p.length()];   
    }
}
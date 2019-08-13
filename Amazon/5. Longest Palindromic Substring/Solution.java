class Solution {
//     public String longestPalindrome(String s) {
//         //Step 1: Define strings - s1, s2, longer, longest
//         String s1 = "", s2 = "", longer = "", longest = "";
        
//         //Step 2: Iterate through the string
//         for(int i = 0; i < s.length(); i++){
//             //Step 3: Check for length if palindrome is odd
//             s1 = pointCheck(s, i , i);
//             //Step 4: Check for length if palindrome is even
//             s2 = pointCheck(s, i, i+1);
//             //Step 5: Check for longer between s1 and s2
//             longer = (s1.length() > s2.length())? s1:s2;
//             //Step 6: Set the longest
//             longest = (longer.length() > longest.length())? longer:longest;
//         }
//         return longest;
//     }
    
//     //Define function to check for palindrome length
//     public String pointCheck(String s, int start, int end){
        
//         //Step 3a: Set two pointers
//         int i = start, j = end;
        
//         //Step 3b: Check for palindrome
//         while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
//             i = start;
//             start--;
//             j = end;
//             end++;
//         }
        
//         //Step 3c: Return for palindrome string found
//         return (j < s.length() && s.charAt(i) == s.charAt(j))? s.substring(i,j+1):"";
//     }
    
    //Method 2
    public String longestPalindrome(String s) {
        //Manacher's Algorithm
        
        char[] T = new char[s.length()*2 + 1];
        int[] Len = new int[T.length];
        
        int p0 = 0, p = 0;
        
        for(int i = 0; i < s.length(); i++){
            T[2*i + 1] = s.charAt(i);
        }
        
        Len[0] = 1;
        
        for(int i = 1; i < Len.length; i++){
            Len[i] = i < p ? Math.min(Len[2*p0 - i], p - i + 1) : 1;
            
            while(i - Len[i] >= 0 && i + Len[i] < T.length && T[i - Len[i]] == T[i + Len[i]]) {
                Len[i]++;
            }
            
            if(Len[i] > p - p0 + 1){
                p0 = i;
                p = i + Len[i] - 1;
            }
        }
        return s.substring((2*p0-p)/2,p/2);
    }
}
class Solution {
    public void reverseString(char[] s) {
        
        // Pointers 
        char temp = ' ';
        
        for(int i = 0; i < (s.length+1)/2; i++){
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
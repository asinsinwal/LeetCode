class Solution {
    // Two pointer algorithm
    public String minWindow(String S, String T) {
        int i = 0;
        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE, left = 0;
        
        while(i < S.length()){
            // find max subsequence
            int sIndex = i, tIndex = 0;
            while(sIndex < S.length()){
                if(S.charAt(sIndex) == T.charAt(tIndex))
                    tIndex++;
                if(tIndex >= T.length())
                    break;
                sIndex++;
            }
            
            if(sIndex == S.length())
                break;
            
            tIndex = T.length()-1;
            end = sIndex;
            
            // find the shortest subsequence
            while(tIndex >= 0){
                if(S.charAt(sIndex) == T.charAt(tIndex))
                    tIndex--;
                
                if(tIndex < 0)
                    break;
                
                sIndex--;
            }
            
            start = sIndex;
            
            if(minLength > end - start + 1){
                minLength = end - start + 1;
                left = start;
            }
            
            i = start + 1;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : S.substring(left, left + minLength);
        
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        else if(haystack.length() == 0)
            return -1;
        
        if(haystack.contains(needle)){
            for(int i = 0; i < haystack.length(); i++){
                if(haystack.substring(i, needle.length() + i).equals(needle))
                    return i;
            }
        }
        
        return -1;
    }
}


// Implement KMP Algorithm
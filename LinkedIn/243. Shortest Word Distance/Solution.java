class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        // 2 pointers
        int ptr1 = -1, ptr2 = -1;
        int result = words.length;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                ptr1 = i;
            else if(words[i].equals(word2))
                ptr2 = i;
            
            if(ptr1 != -1 && ptr2 != -1)
                result = Math.min(result, Math.abs(ptr1 - ptr2));
        }
        
        return result;
    }
}
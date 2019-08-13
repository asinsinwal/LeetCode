class WordDistance {
    
    // Create a map of words and their location
    Map<String, ArrayList<Integer>> locations;
    
    public WordDistance(String[] words) {
        this.locations = new HashMap<String, ArrayList<Integer>>();
        
        ArrayList<Integer> location;
        
        for(int i = 0; i < words.length; i++){
            location = locations.getOrDefault(words[i], new ArrayList<Integer>());
            location.add(i);
            
            locations.put(words[i], location);
        }
    }
    
    public int shortest(String word1, String word2) {
        ArrayList<Integer> word1_location = locations.get(word1);
        ArrayList<Integer> word2_location = locations.get(word2);
        
        int ptr1 = 0, ptr2 = 0;
        int result = Integer.MAX_VALUE;
        
        while(ptr1 < word1_location.size() && ptr2 < word2_location.size()){
            result = Math.min(result, Math.abs(word1_location.get(ptr1) - word2_location.get(ptr2)));
            
            if(word1_location.get(ptr1) < word2_location.get(ptr2))
                ptr1++;
            else
                ptr2++;
        }
        
        return result; 
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
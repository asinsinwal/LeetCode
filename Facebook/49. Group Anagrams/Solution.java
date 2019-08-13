class Solution {
    //Method: HashMap
    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge case
        if(strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        
        // Define HashMap, list and variables
        Map<String, Integer> anagMap = new HashMap<>();
        List<List<String>> result = new ArrayList<List<String>>();
        String key = "";
        List<String> temp;
        
        // Iteratethrough strings
        for(int i = 0; i < strs.length; i++){
            // Sort the string
            key = sortString(strs[i]);
            
            // Check if sorted string is in the map
            if(anagMap.containsKey(key)){
                // Add to the list and sort the order
                temp = result.get(anagMap.get(key));
                addToGroup(temp,strs[i]);
                
            }else{                  // If not, add the key and the list to the result list
                temp = new ArrayList<>();
                temp.add(strs[i]);
                result.add(temp);
                anagMap.put(key, result.size() - 1);
            }
        
        }
        // Return result list
        return result;
    }
    
    
    // Function to sort the chars in string
    private String sortString(String str){
        char[] char_array = str.toCharArray();
        Arrays.sort(char_array);
        return String.valueOf(char_array);
    }
    
    // Function to add into the list (with sorted order)
    private void addToGroup(List<String> result, String str){
        for(int i = 0; i < result.size(); i++){
            if(result.get(i).compareTo(str) > 0){
                result.add(i, str);
                return;
            }
        }
        result.add(str);
    }
}
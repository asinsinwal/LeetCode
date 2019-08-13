class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> char_frequency = new HashMap<>();
        
        int temp = 0; 
        for(int i = 0; i < s.length(); i++){
            
            if(char_frequency.containsKey(s.charAt(i))){
                temp = char_frequency.get(s.charAt(i));
                char_frequency.put(s.charAt(i), temp+1);
            }else
                char_frequency.put(s.charAt(i), 1);
        }
        
        int result = -1;
        for(int index = 0; index < s.length(); index++){
            if(char_frequency.get(s.charAt(index)) == 1){
                result = index;
                break;
            }
        }
        
        return result;
    }
}
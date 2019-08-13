class Solution {
    
    // Method Greedy - Two pointers
    public List<Integer> partitionLabels(String S) {
        int[] last_occurrence = new int[26];
        
        for(int i = 0; i < S.length(); i++)
            last_occurrence[S.charAt(i) - 'a'] = i;
        
        int ptr = 0;
        int current_string = 0;
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < S.length(); i++){
            ptr = Math.max(ptr, last_occurrence[S.charAt(i)-'a']);
            
            if(ptr == i){
                result.add(i - current_string + 1);
                current_string = i + 1;
            }
        }
        
        return result;
    }
}
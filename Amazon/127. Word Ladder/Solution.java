class Solution {
    
    // Method Single directional BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> diction = new HashSet<>(wordList);
        
        if(!diction.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int result = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = size-1; i >= 0; i--){
                String word = queue.poll();
                
                if(word.equals(endWord))
                    return result + 1;
                
                //Iterate on character
                for(int k = word.length()-1; k >= 0; k--){
                    char[] wordArray = word.toCharArray();
                    
                    for(char c = 'a'; c <= 'z'; c++){
                        wordArray[k] = c;
                        String newString = new String(wordArray);
                        
                        if(diction.contains(newString) && !newString.equals(word)){
                            System.out.println(newString);
                            queue.offer(newString);
                            diction.remove(newString);
                        }
                    }
                }
            }
            result++;
        }
        
        return 0;
    }
}
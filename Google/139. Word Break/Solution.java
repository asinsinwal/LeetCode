class Solution {
    
    // Method 1: BFS
//     public boolean wordBreak(String s, List<String> wordDict) {
//         // Define DS in use
//         Set<String> wordDictSet = new HashSet<>(wordDict);
//         Queue<Integer> queue = new LinkedList<Integer>();
//         boolean[] visited = new boolean[s.length()];
        
//         //Add the start point for string
//         queue.add(0);
        
//         //Variables to be used in loop
//         int start = 0, end = 0;
        
//         while(!queue.isEmpty()){
//             start = queue.remove();
            
//             if(!visited[start]){
//                 for(end = start + 1; end <= s.length(); end++){
//                     if(wordDictSet.contains(s.substring(start, end))){
//                         queue.add(end);
//                         if(end == s.length())
//                             return true;
//                     }
//                 }
//             }
//             visited[start] = true;
//         }
//         return false;
//     }
    
    // Method 2: DFS
    public boolean wordBreak(String s, List<String> wordDict) {
        //Define dp table
        boolean[] dp = new boolean[s.length()+1];
        Set<String> wordDictSet = new HashSet<>(wordDict);
        
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(wordDictSet.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;                    
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

/* 
    Time Complexity:
    BFS = O(n^2)
    DFS = O(n^2)

    Space Complexity:
    BFS = O(n)  Queue of n
    DFS = O(n)  dp of size n
*/
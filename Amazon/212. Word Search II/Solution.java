class Solution {
    private final int[] row_n = new int[]{0, 1, 0, -1};
    private final int[] col_n = new int[]{1, 0, -1, 0};
    
    // DFS and backtracking
    public List<String> findWords(char[][] board, String[] words) {
        
        // Step 1: Define DS needed for the solution
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int k = 0;
        
        
        for(int i = 0; i < words.length; i++){
            if(utilDFSCaller(board, visited, words[i]))
                addToResult(result, words[i]);
            reset(visited);
        }
          
        return result;
    }
    
    /*
    *   Function will call the DFS if first character is found
    */
    private boolean utilDFSCaller(char[][] board, boolean[][] visited, String word){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, visited, word, 0, i, j))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    /* 
    *   Function to add word into list in alphabetical order
    */
    private void addToResult(List<String> result, String word){
        for(int i = 0; i < result.size(); i++){
            if(result.get(i).compareTo(word) > 0){
                result.add(i, word);
                return;
            }
        }
        result.add(word);
    }
    
    /* 
    *   Function to backtrack a possible solution
    */
    private boolean dfs(char[][] board, boolean[][] visited, String word, int index, int row, int col){
        // System.out.println("Row: " + row + " Col: " + col + " Word Char: " + word.charAt(index));
        if(index == word.length() - 1)
            return true;
        
        visited[row][col] = true;
        
        boolean inner_result = false;
        
        for(int i = 0; i < 4; i++){
            if(isSafe(board, visited, word, index + 1, row + row_n[i], col + col_n[i])){
                if(dfs(board, visited, word, index + 1, row + row_n[i], col + col_n[i])){
                    inner_result = true;
                    break;
                }
            }
        }
        
        if(!inner_result)
            visited[row][col] = false;
        
        return inner_result;
    }
    
    /*
    *   Check if move is possible
    */
    private boolean isSafe(char[][] board, boolean[][] visited, String word, int index, int row, int col){
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col] && board[row][col] == word.charAt(index));
    }
    
    /*
    *   Reset the board
    */
    private void reset(boolean[][] visited){
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++)
                visited[i][j] = false;
        }
    }
    
}
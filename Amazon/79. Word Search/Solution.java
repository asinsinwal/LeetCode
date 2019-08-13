class Solution {
    private final int[] row_n = new int[]{0, 1, 0, -1};
    private final int[] col_n = new int[]{1, 0, -1, 0};
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, visited, word, 0, i, j))
                        return true;
                    reset(visited);
                }
            }
        }
        
        return false;
    }
    
    private void reset(boolean[][] visited){
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++)
                visited[i][j] = false;
        }
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int index, int row, int col){
        
        if(index == word.length()-1)
            return true;
        
        visited[row][col] = true;
        
        // inner result
        boolean inner_result = false;
        
        for(int k = 0; k < 4; k++){
            if(isSafe(board, visited, word, index+1, row + row_n[k], col + col_n[k])){
                if(dfs(board, visited, word, index+1, row + row_n[k], col + col_n[k])){
                    inner_result = true;
                    break;
                }
            }
        }
        
        if(inner_result == false)
            visited[row][col] = false;
        
        return inner_result;
    }
    
    private boolean isSafe(char[][] board, boolean[][] visited, String word, int index, int row, int col){
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col] && board[row][col] == word.charAt(index));
    }
}
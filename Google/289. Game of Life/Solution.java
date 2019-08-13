class Solution {
    
    private final int[] row_n = new int[] {1,0,-1,0,-1,1,-1,1};
    private final int[] col_n = new int[] {0,1,0,-1,1,1,-1,-1};
    
    public void gameOfLife(int[][] board) {
        int[][] new_state = new int[board.length][board[0].length];
        
        // Set variables
        int count = 0;
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                count = 0;
                for(int k = 0; k < 8; k++){
                    if(isSafe(board, row + row_n[k], col + col_n[k])){
                        
                        if(board[row + row_n[k]][col + col_n[k]] == 1)
                            count++;
                    }
                }
                
                if(board[row][col] == 1){
                    if(count < 2 || count > 3)
                        new_state[row][col] = 0;
                    else
                        new_state[row][col] = 1;
                }else{
                    if(count == 3)
                        new_state[row][col] = 1;
                }
            }
        }
        
        for(int i=0; i < new_state.length; i++) {
            board[i] = Arrays.copyOf(new_state[i], new_state[i].length);
        }
    }
    
    private boolean isSafe(int[][] board, int row, int col){
        return (row >= 0 && col >= 0 && row < board.length && col < board[0].length);
    }
}
/*
* Method: Keeping count of Rows / Cols / Diagonals / Antidiagonals
* From hint
*/
class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int anti_diagonal;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        anti_diagonal = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int value = (player == 1) ? 1 : -1;
        rows[row] += value;
        cols[col] += value;
        
        if(row == col)
            diagonal += value;
        
        if(row == rows.length - col - 1)
            anti_diagonal += value;
        
        int length = rows.length;
        
        if(Math.abs(rows[row]) == length || Math.abs(cols[col]) == length || Math.abs(diagonal) == length || Math.abs(anti_diagonal) == length)
            return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
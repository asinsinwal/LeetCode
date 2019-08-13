class Solution {
    
    private final int[] row_n = new int[] {-1,1,0,0};
    private final int[] col_n = new int[] {0,0,1,-1};
    
    public int numIslands(char[][] grid) {
        
        //Edge case
        if(grid == null || grid.length == 0)
            return 0;
        
        int islands = 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, visited, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private boolean isSafe(char[][] grid,boolean[][] visited, int next_row, int next_col){
        return (next_row >= 0 && next_col >= 0 && next_row < grid.length && next_col < grid[0].length && grid[next_row][next_col] == '1' && !visited[next_row][next_col]);
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int row, int col){
        visited[row][col] = true;
        
        //traverse through the island
        for(int k = 0; k < 4; k++){
            if(isSafe(grid, visited, row + row_n[k], col + col_n[k]))
                dfs(grid, visited, row+row_n[k], col+col_n[k]);
        }
    }
}
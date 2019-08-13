class Solution {
    
    // O(m*n)
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        // store result
        int perimeter = 0;
        int temp = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                    continue;
                
                temp = 0;
                temp += j-1 < 0 ? 0 : grid[i][j-1];
                temp += j+1 >= grid[0].length ? 0 : grid[i][j+1];
                temp += i-1 < 0 ? 0 : grid[i-1][j];
                temp += i+1 >= grid.length ? 0 : grid[i+1][j];
                
                perimeter += 4 - temp;
            }
        }
        
        return perimeter;
    }
}
class Solution {
    
    private final int[] row_n = new int[]{-1,1,0,0};
    private final int[] col_n = new int[]{0,0,-1,1};
    private int oldColor = -1;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {  
        if(image == null || image.length == 0)
            return image;
        
        oldColor = image[sr][sc];
        if(oldColor == newColor)
            return image;
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, visited, sr, sc, newColor);
        return image;
    }
    
    
    private void dfs(int[][] image, boolean[][] visited, int sr, int sc, int newColor){
        
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        
        for(int i = 0; i < 4; i++){
            if(isSafe(image, visited, sr + row_n[i], sc +col_n[i]))
                dfs(image, visited, sr+row_n[i], sc+col_n[i], newColor);
        }
    }
    
    private boolean isSafe(int[][] image, boolean[][] visited, int row, int col){
        return (row >= 0 && row < image.length && col >= 0 && col < image[0].length && !visited[row][col] && image[row][col] == oldColor);
    }
}
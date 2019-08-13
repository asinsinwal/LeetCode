class Solution {
    
    // No of days = no of different rorations
    public int[] prisonAfterNDays(int[] cells, int N) {
        cells = cellsAfterOneDay(cells);
        // System.out.println(Arrays.toString(cells));
        cells = cellsBeforeOneDay(cells);
        // System.out.println(Arrays.toString(cells));
        
        N = N%14;
        
        if(N < 7){
            for(int i = 0; i < N; i++)
                cells = cellsAfterOneDay(cells);
        }else{
            N = 14 - N;
            
            for(int j = 0; j < N; j++)
                cells = cellsBeforeOneDay(cells);
        }
        
        return cells;
    }
    
    private int[] cellsAfterOneDay(int[] cells){
        int[] updated_cells = new int[8];
        
        for(int i = 1; i < 7; i++)
            updated_cells[i] = 1 - Math.abs(cells[i-1] - cells[i+1]);
        
        return updated_cells;
        
    }
    
    private int[] cellsBeforeOneDay(int[] cells){
        int[] updated_cells = new int[8];
        
        for(int i = 2; i < 7; i+=2)
            updated_cells[i] = (cells[i-1] == 0) ? 1 - updated_cells[i-2] : updated_cells[i-2];
        
        for(int i = 5; i > 0; i-=2)
            updated_cells[i] = (cells[i+1] == 0) ? 1 - updated_cells[i+2] : updated_cells[i+2];
        
        return updated_cells;
    }
}
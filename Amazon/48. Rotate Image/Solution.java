class Solution {
    //Array Solution
//     public void rotate(int[][] matrix) {
//         //Declare variables
//         int temp = 0;
        
//         //2-D loop
//         for(int i = 0; i < matrix.length/2; i++){
            
//             for(int j = i; j < matrix.length-1-i; j++){
                
//                 temp = matrix[i][j];
//                 matrix[i][j] = matrix[matrix.length - j - 1][i];
//                 matrix[matrix.length-j-1][i] = matrix[matrix.length-i-1][matrix.length-j-1];
//                 matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length-i-1];
//                 matrix[j][matrix.length-i-1] = temp;
//             }
//         }
//     }
    
    
    //Actual Solution
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        
        transpose(matrix);
        mirrorHorizontal(matrix);
    }
    
    private void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix.length; j++){
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    private void mirrorHorizontal(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length/2; j++){
                swap(matrix, i, j, i, matrix.length - j -1);
            }
        }
    }
    
    private void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}




// [0,0] = [2,0]
// [0,1] = [1,0]
// [0,2] = [0,0]
// [1,2] = [0,1]
// [2,2] = [0,2] 
// [2,1] = [1,2]
// [2,0] = [2,2]

// Figured out.!
// [i][j] = [l - j - 1][i]
// [l-j-1][i] = [l-i-1][l-j-1]
// [l-i-1][l-j-1] = [j][l-i-1]
// [j][l-i-1] = [i,j]


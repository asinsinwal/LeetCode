class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        // Set temp variable used in loop
        int temp = 0;
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < (A[0].length + 1)/2; j++){
                temp = A[i][j] ^ 1;
                A[i][j] = A[i][A[0].length-j-1] ^ 1;
                A[i][A[0].length-j-1] = temp;
            }
        }
        
        return A;
        
    }
}
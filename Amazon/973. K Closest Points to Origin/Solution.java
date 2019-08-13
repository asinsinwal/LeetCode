class Solution {
    
    // Euclidean distance    Time:(N log N) and Space:O(N)
//     public int[][] kClosest(int[][] points, int K) {
        
//         int[] distances = new int[points.length];
        
//         for(int i = 0; i < points.length; i++)
//             distances[i] = calculateDistance(points[i]);
        
//         Arrays.sort(distances);
//         int kth_distance = distances[K-1];
        
//         int[][] result = new int[K][2];
//         int temp = 0;
        
//         for(int i = 0; i < points.length; i++)
//             if(calculateDistance(points[i]) <= kth_distance)
//                 result[temp++] = points[i];
        
//         return result;
//     }
    
//     private int calculateDistance(int[] point){
//         return point[0]*point[0] + point[1]*point[1];
//     }
    
    
    // QuickSelect and Heap Time: O(N) and Space: O(N)
    Random rndm = new Random();
    
    public int[][] kClosest(int[][] points, int K) {
        quickSelect(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private void swap(int[][] points, int i, int j){
        int px = points[i][0], py = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = px;
        points[j][1] = py;
    }
    
    private int calculateDistance(int[][] points, int p){
        return points[p][0]*points[p][0] + points[p][1]*points[p][1];
    }
    
    private int partition(int[][]points, int x, int y){
        int ptr = x;
        int pivot = calculateDistance(points, x);
        x++;
        
        while(true){
            while(x < y && calculateDistance(points, x) < pivot)
                x++;
            while(x <= y && calculateDistance(points, y) > pivot)
                y--;
            
            if(x >= y)
                break;
            
            swap(points, x, y);
        }
        swap(points, ptr, y);
        return y;
    }
    
    private void quickSelect(int[][] points, int left, int right, int K){
        
        if( left >= right)
            return;
        
        int pivot = left + rndm.nextInt(right - left);
        
        swap(points, left, pivot);
    
        int mid = partition(points, left, right);
        int left_length = mid - left + 1;
        
        
        if(K < left_length)
            quickSelect(points, left, mid - 1, K);
        else if(K > left_length)
            quickSelect(points, mid + 1, right, K - left_length);
    }
}


class Solution {
    
    // method  1: DFS
//     public int minCost(int[][] costs) {
        
//         int[] chosen = new int[costs.length*3];
        
//         if(costs == null || costs.length == 0)
//             return 0;
        
//         return (Math.min(Math.min(calculateMinCost(costs, 0, 0, chosen, 0), calculateMinCost(costs, 0, 1, chosen, 0)), calculateMinCost(costs, 0, 2, chosen, 0)));
//     }
    
//     private int calculateMinCost(int[][] costs, int house, int color, int[] chosen, int minCost){
//         if(house == costs.length)
//             return minCost;
        
//         int index = house*3 + color;
//         int recordMin = chosen[index];
        
//         if(recordMin == 0){
//             recordMin = Math.min(calculateMinCost(costs, house + 1, nextColor(color - 1), chosen, recordMin),
//                                  calculateMinCost(costs, house + 1, nextColor(color + 1), chosen, recordMin)) + costs[house][color];
//         }
        
//         chosen[index] = recordMin;
        
//         return recordMin;
//     }
    
//     private int nextColor(int color){
//         if(color < 0)
//             return 2;
//         else if(color == 3)
//             return 0;
        
//         return color;
//     }
    
    // Method 2: Iteration
    public int minCost(int[][] costs) {
        
        int ifRed = 0, ifBlue = 0, ifGreen = 0;
        int lastRed = 0, lastBlue = 0, lastGreen = 0;
        
        for(int i = 0; i < costs.length; i++){
            ifRed = Math.min(lastBlue, lastGreen) + costs[i][0];
            ifBlue = Math.min(lastRed, lastGreen) + costs[i][1];
            ifGreen = Math.min(lastRed, lastBlue) + costs[i][2];
            lastRed = ifRed;
            lastBlue = ifBlue;
            lastGreen = ifGreen;
        }
        
        return (Math.min(Math.min(lastRed, lastBlue), lastGreen));
    }
}
class Solution {
    
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] x, int[] y){
            return x[0] < y[0]? -1 : x[0] == y[0] ? 0 : 1;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        // Edge case
        if(intervals == null || intervals.length <= 1)
            return intervals;
        
        // Sort the intervals according to the row values
        Arrays.sort(intervals, new IntervalComparator());
        
        // Define the DS to store the values
        List<List<Integer>> merged = new ArrayList<List<Integer>>();
        List<Integer> values = new ArrayList<>();
        values.add(intervals[0][0]);
        values.add(intervals[0][1]);
        merged.add(values);
        
        List<Integer> temp;
        // Check for the intervals overlap
        for(int i = 1; i < intervals.length; i++){
            temp = merged.get(merged.size() - 1);
            if( temp.get(1) >= intervals[i][0]){
                temp.set(1, Math.max(temp.get(1),intervals[i][1]));
                merged.set(merged.size() - 1, temp);
            }else{
                temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                merged.add(temp);
            }
        }
        
        // Convert List of List into array
        int[][] result = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++){
            temp = merged.get(i);
            result[i][0] = temp.get(0);
            result[i][1] = temp.get(1);
        }
        
        return result;
    }
}
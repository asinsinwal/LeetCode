class Solution {
    
    public int minMeetingRooms(int[][] intervals) {
        // Edge case
        if(intervals == null || intervals.length == 0)
            return 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < start.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int ptr_e = 0;
        int rooms = 0;
        for(int ptr_s = 0; ptr_s < start.length; ptr_s++){
            if(start[ptr_s] < end[ptr_e])
                rooms++;
            else
                ptr_e++;
        }
        
        return rooms;
    }
}
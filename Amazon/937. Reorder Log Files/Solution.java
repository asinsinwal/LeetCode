class Solution {
    
    // Custom log or amortized log -> O(N log N) and spcae O(N)
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, (log1, log2) -> {
            // Split both log strings
            String[] splitlog1 = log1.split(" ", 2);
            String[] splitlog2 = log2.split(" ", 2);
            
            // Check if any of them are numbers
            boolean isSet1digit = Character.isDigit(splitlog1[1].charAt(0));
            boolean isSet2digit = Character.isDigit(splitlog2[1].charAt(0));
            
            // If both are set of strings then compare the inner string for lexicographical order
            if(!isSet1digit && !isSet2digit){
                int value = splitlog1[1].compareTo(splitlog2[1]);
                
                
                if(value != 0)
                    return value;
                else
                    return splitlog1[0].compareTo(splitlog2[0]);
            }
            
            return isSet1digit ? ( isSet2digit ? 0 : 1) : -1;
        });
        
        return logs;
    }
}
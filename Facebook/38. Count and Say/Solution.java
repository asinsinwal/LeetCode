class Solution {
    
    //Method 1: StringBuilder
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        StringBuilder result = new StringBuilder("");
        StringBuilder current = new StringBuilder("1");
        
        int count = 1;
        char prev = ' ', curr = ' ';
        
        for(int i = 1; i < n; i++){
            prev = current.charAt(0);
            count = 1;
            result = new StringBuilder("");
            for(int j = 1; j < current.length(); j++){
                curr = current.charAt(j);
                if(prev != curr ){
                    result.append(count).append(prev);
                    count = 0;
                }
                count++;
                prev = curr;
            }
            result.append(count).append(prev);
            current = result;
        }
        
        return result.toString();
    }
}
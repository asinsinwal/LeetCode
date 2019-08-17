class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0)
            return s.substring(0,1);
        
        int[] tFreq = new int[128];
        
        for(int i = 0; i < t.length(); i++)
            tFreq[t.charAt(i)] += 1;
        
        // System.out.println(Arrays.toString(tFreq));
        
        int minLength = Integer.MAX_VALUE;
        int tCount = t.length();
        int begin = -1;
        
        for(int left = 0, right = 0; right < s.length(); right++){
            char temp = s.charAt(right);
            
            tFreq[temp] -= 1;
            
            if(tFreq[temp] >= 0)
                tCount--;
            
            while(tCount == 0){
                char c = s.charAt(left);
                
                tFreq[c] += 1;
                
                if(tFreq[c] > 0){
                    if(right-left+1 < minLength){
                        begin = left;
                        minLength = right-left+1;
                    }
                    tCount++;
                }
                left++;
            }
        }
        // System.out.println(begin + " " + minLength);
        return (minLength == Integer.MAX_VALUE) ? "":s.substring(begin, begin + minLength);
        
    }
}
class Solution {
    
    List<Integer> sums;
    int total;
    Random random;
    
    public Solution(int[] w) {
        sums = new ArrayList<>();
        total = 0;
        random = new Random();
        
        for(int i : w){
            total += i;
            sums.add(total);
        }
    }
    
    public int pickIndex() {
        int rndm = random.nextInt(total);
        
        int low = 0, high = sums.size()-1;
        
        while(low != high){
            int mid = (low+high)/2;
            if(rndm >= sums.get(mid))
                low = mid+1;
            else
                high = mid;
        }
        
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
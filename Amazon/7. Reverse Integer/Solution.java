class Solution {
    public int reverse(int x) {
        boolean sign = false;
        
        if(x < 0){
            sign = true;
            x *= -1;
        }
        
        long result = 0;
        while(x > 0){
            result *= 10;
            result += x%10;
            x=x/10;
        }
        
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return 0;
        
        if(sign)
            return (int)result*-1;
        
        return (int)result;
    }
}
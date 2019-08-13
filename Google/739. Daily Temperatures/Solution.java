class Solution {
    public int[] dailyTemperatures(int[] T) {
        // Define Stack and store the max temperatures' indexes
        Stack<Integer> stack = new Stack();
        
        // result array
        int[] result = new int[T.length];
        int diff = 1;
        
        for(int i = T.length - 1; i >= 0; i--){
            while(!stack.isEmpty()){
                if(T[i] < T[stack.peek()]){
                    result[i] = stack.peek() - i;
                    stack.push(i);
                    break;
                }else
                    stack.pop();
            }
            
            if(stack.isEmpty()){
                result[i] = 0;
                stack.push(i);
            }
        }
        
        return result;
    }
}
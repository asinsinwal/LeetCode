class MinStack {
    
    Stack<Long> stack;
    long min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push((long)x);
            min = (long)x;
        }else{
            if((long)x < min){
                stack.push(2*(long)x - min);
                min = (long)x;
            }else{
                stack.push((long)x);
            }
        }
    }
    
    public void pop() {
        if(min > stack.peek()){
            min = 2*min - stack.pop();
        }else{
            stack.pop();
        }
    }
    
    public int top() {
        if(min > stack.peek()){
            return (int)min;
        }else{
            long temp = stack.peek();
            return (int)temp;
        }
    }
    
    public int getMin() {
        if(!stack.isEmpty())
            return (int)min;
        
        return Integer.MIN_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
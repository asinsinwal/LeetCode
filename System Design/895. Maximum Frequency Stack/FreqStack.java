// Two Stack method
class FreqStack {
    Map<Integer, Integer> frequency;
    Map<Integer, Stack<Integer>> cluster;
    private int max = 0;
    
    public FreqStack() {
        frequency = new HashMap<>();
        cluster = new HashMap<>();
        max = 0;
    }
    
    public void push(int x) {
        int freq = frequency.getOrDefault(x, 0) + 1;
        
        frequency.put(x, freq);
        
        if(max < freq)
            max = freq;
        
        if(!cluster.containsKey(freq))
            cluster.put(freq, new Stack<>());
        
        Stack tmp = cluster.get(freq);
        tmp.push(x);
        
        cluster.put(freq, tmp);
    }
    
    public int pop() {
        int top = cluster.get(max).pop();
        
        frequency.put(top, frequency.get(top) - 1);
        
        if(cluster.get(max).size() == 0)
            max--;
        
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
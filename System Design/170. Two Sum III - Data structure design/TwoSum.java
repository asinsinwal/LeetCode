class TwoSum {
    Map<Integer, Integer> storage;
    /** Initialize your data structure here. */
    public TwoSum() {
        storage = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(storage.containsKey(number))
            storage.put(number, storage.get(number) + 1);
        else
            storage.put(number, 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        Iterator<Map.Entry<Integer, Integer>> itr = storage.entrySet().iterator();
        Map.Entry<Integer, Integer> temp; 
        int num1 = 0, num2 = 0;
        
        while(itr.hasNext()){
            temp = itr.next();
            num1 = temp.getKey();
            num2 = value - num1;
            if((num1 == num2 && storage.get(num1) > 1) || storage.containsKey(num2) && num1 != num2)
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> frequency.get(n1) - frequency.get(n2));
        
        for(int i = 0; i < nums.length; i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int i: frequency.keySet()) {
            heap.add(i);
            if(heap.size() > k)
                heap.poll();
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!heap.isEmpty())
            result.add(heap.poll());
        
        Collections.reverse(result);
        
        return result;
    }
}
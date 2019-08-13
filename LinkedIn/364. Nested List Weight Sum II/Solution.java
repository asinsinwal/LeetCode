/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    
    private int reverse_sum = 0;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = maxDepth(nestedList);
        // System.out.println(depth);
        
        return utilInverseSum(nestedList, depth);
    }
    
    private int maxDepth(List<NestedInteger> nestedList){
        int depth = 1;
        
        for(NestedInteger nestedInt: nestedList){
            if(!nestedInt.isInteger())
                depth = Math.max(depth, maxDepth(nestedInt.getList()) + 1);
        }
        
        return depth;
    }
    
    private int utilInverseSum(List<NestedInteger> nestedList, int depth) {
        
        for(NestedInteger nestedInt: nestedList)
            checkDepthandValue(nestedInt, depth);
        
        return reverse_sum;
    }
    
    private void checkDepthandValue(NestedInteger nestedInt, int depth){
        if(nestedInt.isInteger()){
            reverse_sum += (nestedInt.getInteger()*depth);
            return;
        }
        
        utilInverseSum(nestedInt.getList(), depth - 1);
    }
}
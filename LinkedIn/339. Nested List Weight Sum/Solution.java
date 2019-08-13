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
    int sum = 0;
    
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0)
            return 0;
        sum = 0;
        utilNestedList(nestedList, 1);
        return sum;
    }
    
    private void utilNestedList(List<NestedInteger> nestedList, int depth){
        for(NestedInteger nestedInt: nestedList)
            utilIntOrList(nestedInt, depth);
    }
    
    private void  utilIntOrList(NestedInteger nestedInt, int depth){
        if(nestedInt.isInteger()){
            sum += (depth*nestedInt.getInteger());
            return;
        }
        
        utilNestedList(nestedInt.getList(), depth + 1);
    }
}
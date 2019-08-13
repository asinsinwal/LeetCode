/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private int index;
    List<Integer> list;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        index = 0;
        list = new ArrayList<>();
        utilNestedList(nestedList);
    }
    
    private void utilNestedList(List<NestedInteger> nestedList){
        for(NestedInteger nextIntOrList: nestedList){
            utilDifferentiator(nextIntOrList);
        }
    }
    
    private void utilDifferentiator(NestedInteger nextIntOrList) {
        if(nextIntOrList.isInteger()){
            list.add(nextIntOrList.getInteger());
            return;
        }
        
        utilNestedList(nextIntOrList.getList());
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return (index < list.size());
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
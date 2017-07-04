/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class LintCode_551 {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> nestedList, int depth){
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        int sum = 0;
        for(NestedInteger ele : nestedList) {
            if (ele.isInteger()) {
                sum += ele.getInteger() * depth;
            } else {
                sum += helper(ele.getList(), depth + 1);
            }
        }
 
        return sum;
    }
}

public class LintCode_551_2 {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        
        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger element : nestedList){
            queue.offer(element);
        }
        
        int depth = 0;
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++){
                NestedInteger e = queue.poll();
                if(e.isInteger()){
                    sum += e.getInteger() * depth;
                }
                else{
                    for(NestedInteger innerE : e.getList()){
                        queue.offer(innerE);
                    }
                }
            }
        }
        return sum;
    }
}
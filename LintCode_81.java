// class comparator implements Comparator<Integer>{
//     public int compare(Integer i, Integer j){
//         return j.compareTo(i);
//     }
// }
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if(nums.length == 0){
            return new int[0];
        }
        
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> less = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            public int compare(Integer i, Integer j){
                return j.compareTo(i);
            }
        });
        PriorityQueue<Integer> larger = new PriorityQueue<Integer>(nums.length);
        int median = nums[0];
        ans[0] = median;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < median){
                less.offer(nums[i]);
            }else{
                larger.offer(nums[i]);
            }
            
            if(larger.size() > less.size() + 1){
                int temp = larger.poll();
                less.offer(median);
                median = temp;
            }
            
            if(less.size() > larger.size()){
                int temp = less.poll();
                larger.offer(median);
                median = temp;
            }
            
            ans[i] = median;
        }
        return ans;
    }
}
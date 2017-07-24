public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(k == 0){
            return ans;
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < k - 1; i++){
            inDeque(deque, nums[i]);
        }
        
        for(int i = k - 1; i < nums.length; i++){
            inDeque(deque, nums[i]);
            ans.add(deque.peekFirst());
            outDeque(deque, nums[i - k + 1]);
        }
        return ans;
    }
    
    private void inDeque(Deque<Integer> deque, int num){
        while(!deque.isEmpty() && num > deque.peekLast()){
            deque.pollLast();
        }
        deque.offerLast(num);
    }
    
    private void outDeque(Deque<Integer> deque, int num){
        if(deque.peekFirst() == num){
            deque.pollFirst();
        }
    }
}
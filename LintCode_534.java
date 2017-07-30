public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if(nums.length == 0){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        return Math.max(helper(0, nums.length - 2, nums), helper(1, nums.length - 1, nums));
    }
    
    private int helper(int start, int end, int[] nums){
        int[] res = new int[2];
        if(start == end){
            return nums[start];
        }
        
        if(start + 1 == end){
            return Math.max(nums[start], nums[end]);
        }
        
        res[start % 2] = nums[start];
        res[(start + 1) % 2] = Math.max(nums[start], nums[start + 1]);
        
        for(int i = start + 2; i <= end; i++){
            res[(i%2)] = Math.max(res[(i - 1)%2], res[(i - 2)%2] + nums[i]);
        }
        
        return res[end%2];
    }
}
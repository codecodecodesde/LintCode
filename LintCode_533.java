public class LintCode_533 {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2){
            return Integer.MAX_VALUE;
        }
        
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int difference = Integer.MAX_VALUE;
        while(start  < end){
            if(nums[start] + nums[end] == target){
                return 0;
            }
            else if(nums[start] + nums[end] < target){
                difference = Math.min(difference, target - nums[start] - nums[end]);
                start++;
            }
            else{
                difference = Math.min(difference, nums[start] + nums[end] - target);
                end--;
            }
        }
        return difference;
    }
}
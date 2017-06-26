public class LintCode_604 {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length < k || k <= 0){
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1]; 
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        result[0] = sum;
        for(int i = 1; i < nums.length - k + 1; i++){
            sum = sum - nums[i - 1] + nums[i + k - 1];
            result[i] = sum;
        }
        
        return result;
    }
}
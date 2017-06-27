public class LintCode_443 {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        while(start < end){
            if(nums[start] + nums[end] > target){
                count += end - start;
                end--;
            }
            else{
                start++;
            }
        }
        return count;
    }
}
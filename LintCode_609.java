public class LintCode_609 {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        int start = 0, end = nums.length - 1; 
        while(start < end){
            if(nums[start] + nums[end] > target){
                end--;
            }
            else{
                count += end - start;
                start++;
            }
        }
        
        return count;
    }
}
public class LintCode_587 {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum == target){
                count++;
                start++;
                end--;
                while(start < end && nums[start] == nums[start - 1]){
                    start++;
                }
                while(start < end && nums[end] == nums[end + 1]){
                    end--;
                }
            }
            else if(sum > target){
                end--;
            }
            else{
                start++;
            }
        }
        return count;
    }
}
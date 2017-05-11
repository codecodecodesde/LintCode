public class LintCode_585 {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0; 
        int end = nums.length - 1;
        while (start + 1  < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]){
                start = mid;
            }
            else if(nums[mid] > nums[mid + 1]){
                end = mid;
            }
            else{
                start = mid;
                end = mid + 1;
            }
        }
        if (nums[start] >= nums[end]){
            return nums[start];
        }
        else{
            return nums[end];
        }
    }
}
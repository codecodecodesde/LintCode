public class LintCode_625 {
    /**
     * @param nums an integer array
     * @param low an integer
     * @param high an integer
     * @return nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        
        int left = 0, right = nums.length - 1;
        while(left <= right){
            while(left <= right && nums[left] < low){
                left++;
            }
            while(left <= right && nums[right] >= low){
                right--;
            }
            
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        right = nums.length - 1;
        while(left <= right){
            while(left <= right && nums[left] <= high){
                left++;
            }
            while(left <= right && nums[right] > high){
                right--;
            }
            
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}
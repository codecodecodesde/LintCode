public class LintCode_539 {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        
        for(int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
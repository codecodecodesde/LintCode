public class LintCode_521 {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[index] != nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
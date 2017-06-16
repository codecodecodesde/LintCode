public class LintCode_52 {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int smallerIndex = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                smallerIndex = i;
                break;
            }
        }
        
        if(smallerIndex == -1){
            swapList(nums, 0, nums.length - 1);
            return nums;
        }
        
        int biggerIndex = -1;
        for(int i = nums.length - 1; i > smallerIndex; i--){
            if(nums[i] > nums[smallerIndex]){
                biggerIndex = i;
                break;
            }
        }
        
        swapItem(nums, smallerIndex, biggerIndex);
        swapList(nums, smallerIndex + 1, nums.length - 1);
        return nums;
    }
    
    private void swapItem(int[] nums, int start, int end){
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
    
    private void swapList(int[] nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            swapItem(nums, i, j);
        }
    }
}
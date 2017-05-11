public class LintCode_159 {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        
        /*-------------------------------------
        // int pivot = nums[nums.length - 1];
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] <= pivot)
        //         return nums[i];
        // }
        // return -1;
        brute force O(N)
        -----------------------------------------*/
        
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        int target = nums[end];
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        
        if(nums[start] > nums[end]){
            return nums[end];
        }
       return nums[start];
    }
}
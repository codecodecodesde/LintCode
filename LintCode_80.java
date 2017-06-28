public class LintCode_80 {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        if(nums.length % 2 == 0){
            return quickSelect(nums, 0, nums.length - 1, nums.length/2);
        }
        else{
            return quickSelect(nums, 0, nums.length - 1, (nums.length + 1)/2);
        }
    }
    
    private int quickSelect(int[] nums, int start, int end, int k){
        if(start == end){
            return nums[start];
        }
        
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(right <= right && nums[right] > pivot){
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
        
        if(start + k - 1 <= right){
            return quickSelect(nums, start, right, k);
        }
        if(start + k - 1 >= left){
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
}
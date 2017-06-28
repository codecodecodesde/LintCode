public class LintCode_31 {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0){
	        return 0;
	    }
	    
	    int left = 0, right = nums.length - 1;
	    while(left <= right){
	        while(left <= right && nums[left] < k){
	            left++;
	        }
	        while(left <= right && nums[right] >= k){
	            right--;
	        }
	        
	        if(left <= right){
	            int tmp = nums[left];
	            nums[left] = nums[right];
	            nums[right] = tmp;
	            left++;
	            right--;
	        }
	    }
	    return left;
    }
}
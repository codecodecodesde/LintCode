public class LintCode_39 {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int end = nums.size() - 1;
        for(int start = 0; start < end; start++){
            if(nums.get(start) > nums.get(start + 1)){
                reverse(nums, 0, start);
                reverse(nums, start + 1, end);
                reverse(nums, 0, end);
            }
        }
        
       
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end){
        while(start < end){
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start++;
            end--;
        }
    }
}
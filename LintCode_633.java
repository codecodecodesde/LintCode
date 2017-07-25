public class Solution {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // Write your code here
        int start = 1;
        int end = nums.length - 1;
        while(start + 1  < end){
            int mid = start + (end - start) / 2;
            if(check(mid, nums) <= mid){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        if(check(start, nums) <= start){
            return end;
        }
        return start;
    }
    
    private int check(int mid, int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= mid){
                count++;
            }
        }
        return count;
    }
}
public class LintCode_608 {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2){
            return null;
        }
        //int[] result = new int[2];
        int start = 0, end = nums.length - 1;
        while(start < end){
            if(nums[start] + nums[end] == target){
                int[] result = new int[]{start + 1, end + 1};
                return result;
            }
            else if(nums[start] + nums[end] > target){
                end--;
            }
            else{
                start++;
            }
        }
        return null;
    }
}
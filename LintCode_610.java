public class LintCode_610 {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int difference = Math.abs(nums[j] - nums[i]);
                if(difference == Math.abs(target)){
                    int[] result = new int[]{i + 1, j + 1};
                    return result;
                }   
            }
        }
        return null;
    }
}
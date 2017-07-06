public class LintCode_76 {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] f = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            f[i] = 1;
        }
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }
        }
        
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, f[i]);
        }
        
        return max;
    }
}
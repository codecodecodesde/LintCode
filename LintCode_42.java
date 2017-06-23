public class LintCode_42 {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for(int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = nums.size() - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size() - 1; i++){
            maxSum = Math.max(maxSum, left[i] + right[i + 1]);
        }
        return maxSum;
    }
}
public class LintCode_617 {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        
        
        while(max - min >= 1e-6){
            double mid = (max + min) / 2.0;
            if(isValid(nums, mid, k)){
                min = mid;
            }
            else{
                max = mid;
            }
        }
        return min;
    }
    
    private boolean isValid(int[] nums, double mid, int k){
        double min_pre = 0;
        double[] sum = new double[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1] - mid;//(a1 + a2 + a3..+ ai) - i*mid
            if(i >= k && sum[i] - min_pre >= 0){
                return true;
            }
            if(i >= k){
                min_pre = Math.min(min_pre, sum[i - k + 1]);
            }
        }
        return false;
    }
}
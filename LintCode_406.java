public class LintCode_406 {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= s){
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        
        if(minLength == Integer.MAX_VALUE){
            return -1;
        }
        return minLength;
    }
}

public class LintCode_406_2 {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int j = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            if(sum >= s){
                length = Math.min(length, j - i);
            }
            sum -= nums[i];
        }
        
        if(length == Integer.MAX_VALUE){
            return -1;
        }
        return length;
    }
}
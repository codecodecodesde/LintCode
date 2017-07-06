public class LintCode_603 {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int[] f = new int[nums.length];
        int[] pre = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    pre[i] = j;
                }
            }
        }
        
        int longest = 0;
        int max_index = 0;
        for(int i = 0; i < nums.length; i++){
            if(f[i] > longest){
                longest = f[i];
                max_index = i;
            }
        }
        
        result.add(nums[max_index]);
        while(max_index != pre[max_index]){
            max_index = pre[max_index];
            result.add(nums[max_index]);
        }
        return result;
    }
}
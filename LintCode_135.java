public class LintCode_135 {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null){
            return result;
        }
        
        if(candidates.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }        
        
        int[] nums = removeDuplicate(candidates);
        List<Integer> subset = new ArrayList<>();
        dfs(nums, result, 0, subset, 0, target);
        return result;
    }
    
    private void dfs(int[] nums, List<List<Integer>> result, int startIndex, List<Integer> subset, int sum, int target){
        
        if(sum == target){
            result.add(new ArrayList<Integer>(subset));
        }
        
        for(int i = startIndex; i < nums.length; i++){
            if(sum > target){
                break;
            }
            subset.add(nums[i]);
            dfs(nums, result, i, subset, sum + nums[i], target);
            subset.remove(subset.size() - 1);
        }
    }
    
    private int[] removeDuplicate(int[] candidates){
        Arrays.sort(candidates);
        
        int index = 0;
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] != candidates[index]){
                candidates[++index] = candidates[i];
            }
        }
        
        int[] nums  = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }
        return nums;
    }
}
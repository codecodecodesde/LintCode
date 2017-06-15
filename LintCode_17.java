class LintCode_17 {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        
        if(nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        dfs(nums, result, subset, 0);
        return result;
    }
    
    private void dfs(int[] nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int startIndex){
        
        result.add(new ArrayList<Integer>(subset));
        
        for(int i = startIndex; i < nums.length; i++){
            subset.add(nums[i]);
            dfs(nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
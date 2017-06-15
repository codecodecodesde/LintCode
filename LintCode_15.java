class LintCode_15 {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        if(nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        List<Integer> permutation = new ArrayList<>();
        dfs(nums, result, permutation);
        return result;
    }
    
    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> permutation){
        if(permutation.size() == nums.length){
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(permutation.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            dfs(nums, result, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }
}

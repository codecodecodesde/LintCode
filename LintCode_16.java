class LintCode_16 {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        if(nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, result, permutation, visited);
        return result;
    } 
    
    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> permutation, boolean[] visited){
        
        if(permutation.size() == nums.length){
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true || i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false){
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, result, permutation, visited);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
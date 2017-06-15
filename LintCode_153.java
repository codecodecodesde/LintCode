public class LintCode_153 {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        
        if(num == null){
            return result;
        }

        Arrays.sort(num);
        List<Integer> subset = new ArrayList<>();
        dfs(num, result, 0, subset, target);
        return result;
    }
    
    private void dfs(int[] num, List<List<Integer>> result, int startIndex, List<Integer> subset, int remainTarget){
        
        if(remainTarget == 0){
            result.add(new ArrayList<Integer>(subset));
        }
        
        for(int i = startIndex; i < num.length; i++){
            if(num[i] > remainTarget){
                break;
            }
            if(i > startIndex && num[i] == num[i -1]){
                continue;
            }
            subset.add(num[i]);
            dfs(num, result, i + 1, subset, remainTarget - num[i]);
            subset.remove(subset.size() - 1);
        }
    }
}
public class LintCode_246 {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        helper(root, result, buffer, target, 0);
        return result;
    }
    
    private void helper(TreeNode root, List<List<Integer>> result, ArrayList<Integer> buffer, int target, int level){
        if(root == null){
            return;
        }
        
        int tmp = target;
        buffer.add(root.val);
        for(int i = level; i >= 0; i--){
            tmp = tmp - buffer.get(i);
            if(tmp == 0){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int j = i; j <= level; ++j){
                    temp.add(buffer.get(j));
                }
                result.add(temp);
            }
        }
        
        helper(root.left, result, buffer, target, level + 1);
        helper(root.right, result, buffer, target, level + 1);
        buffer.remove(buffer.size() - 1);
    }
}
public class LintCode_376 {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        if(root == null){
            return paths;
        }
        
        if(root.left == null && root.right == null){
            if(root.val == target){
                ArrayList<Integer> path = new ArrayList<>();
                path.add(root.val);
                paths.add(path);
            }
            return paths;
        }

        List<List<Integer>> leftPaths = binaryTreePathSum(root.left, target - root.val);
        List<List<Integer>> rightPaths = binaryTreePathSum(root.right, target - root.val);
        
       for(List<Integer> path: leftPaths){
           List<Integer> tmp1 = new ArrayList<>();
           tmp1.add(root.val);
           tmp1.addAll(path);
           paths.add(tmp1);
        }
        for(List<Integer> path: rightPaths){
           List<Integer> tmp2 = new ArrayList<>();
           tmp2.add(root.val);
           tmp2.addAll(path);
           paths.add(tmp2);
        }
        
        return paths;
    }
}

public class LintCode_376_2 {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, path, result, root.val, target);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> path, List<List<Integer>> result, int sum, int target){
        if(root.left == null && root.right == null){
            if(sum == target){
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        if(root.left != null){
            path.add(root.left.val);
            helper(root.left, path, result, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            path.add(root.right.val);
            helper(root.right, path, result, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
}
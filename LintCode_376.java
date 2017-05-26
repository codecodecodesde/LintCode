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
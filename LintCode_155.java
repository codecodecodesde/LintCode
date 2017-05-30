public class LintCode_155 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root);
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        if(root.left == null && root.right == null){
            return 1;
        }
        
        int leftLength = helper(root.left);
        int rightLength = helper(root.right);
        return Math.min(leftLength, rightLength) + 1;
    }
}
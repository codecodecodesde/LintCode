public class LintCode_475 {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null){
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        int curSum = Math.max(left, right) + root.val;
        return Math.max(curSum, root.val);
    }
}
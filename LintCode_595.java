public class LintCode_595 {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    private int longest;
    public int longestConsecutive(TreeNode root) {
        longest = 0;
        helper(root);
        return longest;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int curlongth = 1;
        if(root.left != null && root.val + 1 == root.left.val){
            curlongth = Math.max(curlongth, left + 1);
        }
        
        if(root.right != null && root.val + 1 == root.right.val){
            curlongth = Math.max(curlongth, right + 1);
        }
        
        if(curlongth > longest){
            longest = curlongth;
        }
        return curlongth;
    }
}
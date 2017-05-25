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

public class LintCode_595_2 {
    private class ResultType {
        int maxInSubtree;
        int maxFromRoot;
        public ResultType(int maxInSubtree, int maxFromRoot) {
            this.maxInSubtree = maxInSubtree;
            this.maxFromRoot = maxFromRoot;
        }
    }
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        return helper(root).maxInSubtree;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        // 1 is the root itself.
        ResultType result = new ResultType(0, 1);
        
        if (root.left != null && root.val + 1 == root.left.val) {
            result.maxFromRoot = Math.max(
                result.maxFromRoot,
                left.maxFromRoot + 1
            );
        }
        
        if (root.right != null && root.val + 1 == root.right.val) {
            result.maxFromRoot = Math.max(
                result.maxFromRoot,
                right.maxFromRoot + 1
            );
        }
        
        result.maxInSubtree = Math.max(
            result.maxFromRoot,
            Math.max(left.maxInSubtree, right.maxInSubtree)
        );
        
        return result;
    }
}
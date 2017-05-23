public class LintCode_597 {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    private class ResultType{
        public int sum;
        public int num;
        public ResultType(int sum, int num){
            this.sum = sum;
            this.num = num;
        }
    }

    private TreeNode subtree = null;//root of subtree with max average value
    private ResultType maxResult = null; 

    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType subtreeResult = new ResultType(left.sum + right.sum + root.val, left.num + right.num + 1);
                
        if(maxResult == null || subtreeResult.sum * maxResult.num > maxResult.sum* subtreeResult.num){
            subtree = root ;
            maxResult = subtreeResult;
        }
        return subtreeResult;
    }
}
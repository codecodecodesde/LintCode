public class LintCode_95 {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private class ResultType{
        public boolean isValid;
        public int min;
        public int max;
        public ResultType(boolean isValid, int min, int max){
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        return helper(root).isValid;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if(left.isValid == false || right.isValid == false){
            return new ResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        if(root.left != null && left.max >= root.val || root.right != null && right.min <= root.val){
             return new ResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
       
    return new ResultType(true, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }
}
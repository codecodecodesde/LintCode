public class LintCode_93 {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    private class ResultType{
      private boolean balanced;
      private int depth;
      private ResultType(boolean balanced, int depth){
          this.balanced = balanced;
          this.depth = depth;
      }
    }
   
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        return helper(root).balanced;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(true, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if(left.balanced == false || right.balanced == false){
            return new ResultType(false, -1);
        }
        
        if(Math.abs(left.depth - right.depth) > 1){
             return new ResultType(false, -1);
        }
        return new ResultType(true, Math.max(left.depth, right.depth) + 1);
    }
}
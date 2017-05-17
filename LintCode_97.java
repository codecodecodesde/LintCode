/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class LintCode_97 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null){
            return depth;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
}

public class LintCode_97_2 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private int depth;
    public int maxDepth(TreeNode root) {
       depth = 0;
       helper(root, 1);
       return depth;
    }
    
    private void helper(TreeNode root, int curDepth){
        if(root == null){
            return;
        }
        
        if(curDepth > depth){
            depth = curDepth;
        }
        
        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }
    
}


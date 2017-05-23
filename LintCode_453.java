public class LintCode_453 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if(root == null){
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        if(leftLast != null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if(rightLast != null){
            return rightLast;
        }
        
        if(leftLast != null){
            return leftLast;
        }
        return root;
    }
}

public class LintCode_453_2 {
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {

        if (root == null){
            return;
        }

        if (lastNode != null){
            lastNode.right = root;
            lastNode.left = null;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
public class LintCode_480 {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> paths = new ArrayList<String>();
        
        if(root == null){
            return paths;
        }
        
        if(root.left == null && root.right == null){
            paths.add(root.val + "");
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        for(String path : leftPaths){
            paths.add(root.val + "->" + path);
        }
        
        for(String path : rightPaths){
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
}

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
public class LintCode_480_2{
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> paths = new ArrayList<String>();
        if(root == null){
            return paths;
        }
        helper(root, String.valueOf(root.val), paths);
        return paths;
    }
    
    private void helper(TreeNode root, String path, List<String> paths){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            paths.add(path);
            return;
        }
        
       if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), paths);
        }
        
        if(root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), paths);
        }
        
    }
}
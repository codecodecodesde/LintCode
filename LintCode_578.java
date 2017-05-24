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
public class Solution {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    private class ResultType{
        public TreeNode node;
        public boolean a_exist, b_exist;
        public ResultType(TreeNode node, boolean a, boolean b){
            this.node = node;
            this.a_exist = a;
            this.b_exist = b;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType result = helper(root, A, B);
        if(result.a_exist && result.b_exist) return result.node;
        return null;
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null){
            return new ResultType(null, false, false);
        }
       
        ResultType left = helper(root.left, A , B);
        ResultType right = helper(root.right, A, B);
        
        boolean a_exist = left.a_exist || right.a_exist || root == A;
        boolean b_exist = left.b_exist || right.b_exist || root == B;
        
        if(root == A || root == B){
            return new ResultType(root, a_exist, b_exist);
        }
        if(left.node != null && right.node != null){
            return new ResultType(root, true, true);
        }
        if(left.node != null){
            return left;
        }
        if(right.node != null){
            return right;
        }
        return new ResultType(null, false, false);
    }
}
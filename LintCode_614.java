/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LintCode_614 {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    private class ResultType{
        public int max_length, max_up, max_down;
        public ResultType(int max, int up, int down){
            this.max_length = max;
            this.max_up = up;
            this.max_down = down;
        }
    }
    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        return helper(root).max_length;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0,0,0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int up = 0, down = 0;
        if(root.left != null && root.val + 1 == root.left.val){
            down = Math.max(down, left.max_down + 1);
        }
        if(root.right != null && root.val + 1 == root.right.val){
            down = Math.max(down, right.max_down + 1);
        }
        if(root.left != null && root.val - 1 == root.left.val){
            up = Math.max(up, left.max_up + 1);
        }
        if(root.right != null && root.val - 1 == root.right.val){
            up = Math.max(up, right.max_up + 1);
        }
        
        int len = up + down + 1;
        len = Math.max(len, Math.max(left.max_length, right.max_length));
        return new ResultType(len, up, down);
        
    }
}
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i <= A.length; i++){
            TreeNode curNode = (i == A.length) ? new TreeNode(Integer.MAX_VALUE): new TreeNode(A[i]);
            while(!stack.empty() && curNode.val > stack.peek().val){
                TreeNode nextNode = stack.pop();
                if(stack.empty()){
                    curNode.left = nextNode;
                }else{
                    TreeNode preNode = stack.peek();
                    if(preNode.val > curNode.val){
                        curNode.left = nextNode;
                    }else{
                        preNode.right = nextNode;
                    }
                }
            }
            stack.push(curNode);
        }
        return stack.peek().left;
    }
}
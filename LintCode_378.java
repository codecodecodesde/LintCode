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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class LintCode_378 {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    private class ResultType{
        public DoublyListNode first;
        public DoublyListNode last;
        public ResultType(DoublyListNode first, DoublyListNode last){
            this.first = first;
            this.last = last;
        }
    }
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if(root == null){
            return null;
        }
        return helper(root).first;
    }
    private  ResultType helper(TreeNode root){
        if(root == null){
            return null;
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);
        ResultType result = new ResultType(null, null);
        if(root.left == null){
             result.first = node;
        }
        else{
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }
        if(root.right == null){
            result.last = node;
        }
        else{
            result.last = right.last;
            node.next = right.first;
            right.first.prev = node;
        }
        return result;
    }
}

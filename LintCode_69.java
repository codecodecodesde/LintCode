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
 
 
public class LintCode_69 {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        
        while(!level.isEmpty()){
            int size = level.size();
            ArrayList<Integer> curLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode head = level.poll();
                curLevel.add(head.val);
                if(head.left != null){
                    level.offer(head.left);
                }
                if(head.right != null){
                    level.offer(head.right);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}
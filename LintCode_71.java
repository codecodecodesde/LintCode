public class LintCode_71 {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> traversal = new ArrayList<>();
        if(root == null){
            return traversal;
        }
        
        LinkedList<ArrayList<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.addFirst(level);
        }
        traversal.addAll(result);
        return traversal;
    }
}

public class LintCode_71_2 {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        Stack<TreeNode> tmp;
        current.push(root);
        
        boolean startLeft = true;
        while(!current.isEmpty()){
            int size = current.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode head = current.pop();
                level.add(head.val);
                if(!startLeft){
                   if(head.right != null){
                        next.push(head.right);
                   }
                    if(head.left != null){
                        next.push(head.left);
                    }
                }
                else{
                    if(head.left != null){
                        next.push(head.left);
                    }
                    if(head.right != null){
                        next.push(head.right);
                    }
                }
            }
            startLeft = !startLeft;
            result.add(level);
            tmp = current;
            current = next;
            next = tmp;
        }
        return result;
    }
}
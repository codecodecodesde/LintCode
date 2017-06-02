public class LintCode_242 {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode head = queue.poll();
            ListNode node = new ListNode(head.val);
            ListNode first = node;
            for(int i = 0; i < size; i++){
               if(i >= 1){
                   head = queue.poll();
                   node.next = new ListNode(head.val);
                   node = node.next;
                }
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(first);
        }
        return result;
    }
}

public class LintCode_242_2{
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ListNode sentinel = new ListNode(0);
            ListNode node = sentinel;
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                node.next = new ListNode(head.val);
                node = node.next;
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(sentinel.next);
        }
        return result;
    }
}
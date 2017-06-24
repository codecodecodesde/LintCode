/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LintCode_599 {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if(node == null){
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        
        ListNode cur = node, next = node.next;
        while(next != node){
            if(x <= next.val && x >= cur.val){
                break;
            }
            if((next.val < cur.val) && (x < next.val || x > cur.val)){
                break;
            }

            cur = next;
            next = next.next;
        }
        
        ListNode newNode = new ListNode(x);
        newNode.next = next;
        cur.next = newNode;
        return newNode;
    }
}
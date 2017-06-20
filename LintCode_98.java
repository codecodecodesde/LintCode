/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class LintCode_98s {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    private ListNode findMid(ListNode head){
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                cur.next = left;
                left = left.next;
            }
            else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        
        if(left == null){
            cur.next = right;
        }
        else{
            cur.next = left;
        }
        
        return dummy.next;
    }
}
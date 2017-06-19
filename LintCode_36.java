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
public class LintCode_36 {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if( m >= n || head == null){
            return head;
        }
        ListNode Dummy = new ListNode(0);
        
        Dummy.next = head;
        ListNode tail1 = Dummy;
        for(int i = 1; i < m; i++){
            head = head.next;
            tail1 = tail1.next;
        }
        
        ListNode newHead = null;
        ListNode tail2 = head;
        for(int i = 0; i < n - m + 1; i++){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        
        tail1.next = newHead;
        tail2.next = head;
        return Dummy.next;
    }
}
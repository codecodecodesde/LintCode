/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LintCode_450 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head != null){
            head = reverse(head, k);
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, int k){
        ListNode n1 = head.next;
        ListNode nk = head;
        for(int i = 0; i < k; i++){
            if(nk.next != null){
                nk = nk.next;
            }
            else{
                return null;
            }
        }
        ListNode nkplus = nk.next;
        
        ListNode prev = head;
        ListNode cur = head.next;
        for(int i = 0; i < k; i++){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        head.next = prev;
        n1.next = nkplus;
        return n1;
    }
}
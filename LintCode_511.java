/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LintCode_511 {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode current = Dummy;
        ListNode prev1 = null, prev2 = null;
        while(current.next != null){
            if(current.next.val == v1){
                prev1 = current;
            }
            else if(current.next.val == v2){
                prev2 = current;
            }
            current = current.next;

        }
        
        if(prev1 == null || prev2 == null){
            return head;
        }
        
        if(prev2.next == prev1){
            ListNode tmp = prev1;
            prev1 = prev2;
            prev2 = tmp;
        }//顺序？？？？
        ListNode node1 = prev1.next;
        ListNode node2 = prev2.next;
        ListNode next2 = node2.next;
        if(prev1.next == prev2){
            prev1.next = node2;
            node2.next = node1;
            node1.next = next2;
        }
        else{
            prev1.next = node2;
            node2.next = node1.next;
            prev2.next = node1;
            node1.next = next2;
        }
        return Dummy.next;
    }
}
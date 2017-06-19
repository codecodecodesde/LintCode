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
public class LintCode_165 {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode Dummy = new ListNode(0);
        ListNode lastNode = Dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                lastNode.next = l1;
                lastNode = l1;
                l1 = l1.next;
            }
            else{
                lastNode.next = l2;
                lastNode = l2;
                l2 = l2.next;
            }
        }
        
        if(l1 == null){
            lastNode.next = l2;
            lastNode = l2;
        }
        else{
            lastNode.next = l1;
            lastNode = l1;
        }

        return Dummy.next;
    }
}
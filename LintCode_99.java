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
public class LintCode_99 {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){
            return;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode first = head;
        
        ListNode mid = findMid(head);
        ListNode second = reverse(mid.next);
        mid.next = null;
        merge(first, second);
    }
    private ListNode findMid(ListNode head){
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
    
    private void merge(ListNode l1, ListNode l2){
        ListNode Dummy = new ListNode(0);
        ListNode head = Dummy;
        int index = 0;
        while(l1 != null && l2 != null){
            if(index % 2 == 0){
                head.next = l1;
                head = l1;
                l1 = l1.next;
            }
            else{
                head.next = l2;
                head = l2;
                l2 = l2.next;
            }
            index++;
        }
        
        if(l1 == null){
            head.next = l2;
        }
        else{
            head.next = l1;
        }
    }
    
}
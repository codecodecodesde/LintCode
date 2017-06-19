/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LintCode_170 {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null){
            return null;
        }

        int length = getLength(head);
        k = k % length;
        if(k == 0){
            return head;
        }
        
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode first = head, last = Dummy, tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        for(int i = 0; i < length - k; i++){
            first = first.next;
            last = last.next;
        }
        last.next = null;
        tail.next = Dummy.next;
        return first;
    
    }
    private int getLength(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }
}
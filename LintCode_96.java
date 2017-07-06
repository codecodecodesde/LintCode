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
public class LintCode_96 {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode small = smallDummy, big = bigDummy;
        while(head != null){
            if(head.val < x){
                small.next = head;
                small = head;
            }
            else{
                big.next = head;
                big = head;
            }
            head = head.next;
        }
        small.next = bigDummy.next;
        big.next = null;
        return smallDummy.next;
    }
}
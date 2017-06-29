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
public class LintCode_129 {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        
        if(hashTable.length == 0){
            return hashTable;
        }
        
        int capacity = hashTable.length;
        int newCapacity = 2 * capacity;
        ListNode[] rehashed = new ListNode[newCapacity];
        for(ListNode node : hashTable){
            while(node != null){
                int hashcode = (node.val % newCapacity + newCapacity) % newCapacity;
                if(rehashed[hashcode] == null){
                    rehashed[hashcode] = new ListNode(node.val);
                }
                else{
                    ListNode dummy = rehashed[hashcode];
                    while(dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(node.val);
                }
                node = node.next;
            }
        }
        return rehashed;
    }
}
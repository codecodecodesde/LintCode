/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class LintCode_105{
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class LintCode_105_2 {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        RandomListNode newHead = extendRandomList(head);
        addRandomPointer(newHead);
        newHead = shortRandomList(newHead);
        return newHead;
        
    }
    private RandomListNode extendRandomList(RandomListNode head){
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        return head;
    }
    
    private void addRandomPointer(RandomListNode head){
        RandomListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;        
        }
    }
    
    private RandomListNode shortRandomList(RandomListNode head){
        RandomListNode cur = head;
        while(cur != null && cur.next != null && cur.next.next != null){
            RandomListNode curCopyNext = cur.next.next;
            cur.next.next = cur.next.next.next;
            cur = curCopyNext;
        }
        return head.next;
    }
}
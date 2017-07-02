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
public class LintCode_104 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }
        
        Queue<ListNode> PQ = new PriorityQueue<>(lists.size(), ListNodeComparator);
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null){
                PQ.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(!PQ.isEmpty()){
            ListNode min = PQ.poll();
            current.next = min;
            current = current.next;
            if(min.next != null){
                PQ.add(min.next);
            }
        }
        
        return dummy.next;
    }

}
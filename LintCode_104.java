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
public class LintCode_104_2{
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        while (lists.size() > 1){
           List<ListNode> new_lists = new ArrayList<ListNode>();
           for(int i = 0; i + 1 < lists.size(); i += 2){
               ListNode merged_node = merge(lists.get(i), lists.get(i + 1));
               new_lists.add(merged_node);
           }
            if(lists.size() % 2 == 1){
                new_lists.add(lists.get(lists.size() - 1));
            }
            lists = new_lists;
        }
        return lists.get(0);

    }
    
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                current.next = node1;
                node1 = node1.next;
            }
            else{
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        
        if(node1 != null){
            current.next = node1;
        }
        else{
            current.next = node2;
        }
        return dummy.next;
    }
}


public class LintCode_104_3 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        
        return dummy.next;
    }
}

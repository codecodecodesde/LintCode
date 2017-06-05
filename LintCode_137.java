/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class LintCode_137 {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
            return node;
        }
        
        ArrayList<UndirectedGraphNode> nodes = getNode(node);
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode n : nodes){
            map.put(n, new UndirectedGraphNode(n.label));
        }
        
        for(UndirectedGraphNode n : nodes){
            UndirectedGraphNode newNode = map.get(n);
            for(UndirectedGraphNode neighbor : n.neighbors){
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
        
    }
    
    private ArrayList<UndirectedGraphNode> getNode(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode head = queue.poll();
            nodes.add(head);
            for(UndirectedGraphNode i : head.neighbors){
                if(set.contains(i)){
                    continue;
                }
            queue.offer(i);
            set.add(i);
            }
        }
        return nodes;
    }
}
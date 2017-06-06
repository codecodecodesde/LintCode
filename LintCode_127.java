/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class LintCode_127 {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
        // write your code here
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
        Queue<DirectedGraphNode> queue = getStartNodes(indegree, graph);
        ArrayList<DirectedGraphNode> order = bfs(queue, indegree);
        return order;
    }
    
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                }
                else{
                    map.put(neighbor, 1);
                }
            }
        }
        return map;
    }
    
    private Queue<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode, Integer> indegree, ArrayList<DirectedGraphNode> graph){
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : graph){
            if(!indegree.containsKey(node)){
                queue.offer(node);
            }
        }
        return queue;
    }
    
    private ArrayList<DirectedGraphNode> bfs(Queue<DirectedGraphNode> queue, Map<DirectedGraphNode, Integer> indegree){
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        while(!queue.isEmpty()){
            DirectedGraphNode head = queue.poll();
            order.add(head);
            for(DirectedGraphNode neighbor: head.neighbors){
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return order;
        
    }
}


public class LintCode_127_2 {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}
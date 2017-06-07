/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class LintCode_431 {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nodes == null){
            return result;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        
        for(UndirectedGraphNode node : nodes){
            if(set.contains(node)){
                continue;
            }
            bfs(set, node, result);
        }
        return result;
    }
    
    private void bfs(Set<UndirectedGraphNode> set, UndirectedGraphNode node, List<List<Integer>> result){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        List<Integer> cc = new ArrayList<>();
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode head = queue.poll();
            cc.add(head.label);
            for(UndirectedGraphNode neighbor: head.neighbors){
                if(set.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                set.add(neighbor);
            }
        }
        Collections.sort(cc);
        result.add(cc);
    }
}
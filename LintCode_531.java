/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class LintCode_531 {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if(graph == null){
            return -1;
        }
        
        if(s.equals(t)){
            return 0;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(s);
        set.add(s);
        
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                UndirectedGraphNode first = queue.poll();
                for(UndirectedGraphNode neighbor : first.neighbors){
                    if(set.contains(neighbor)){
                        continue;
                    }
                    if(neighbor.equals(t)){
                        return level;
                    }
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return -1;
    }
}
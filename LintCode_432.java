/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
class UnionFind{
    private Map<Integer, Integer> father;
    public UnionFind(Set<Integer> labels){
        father = new HashMap<Integer, Integer>();
        for(Integer i : labels){
            father.put(i, i);
        }
    }

    public int find(int x){
        int parent = father.get(x);
        while(parent != father.get(parent)){
            parent = father.get(parent);
        }
        
        int temp = -1;
        int f = father.get(x);
        while(f != father.get(f)){
            temp = father.get(f);
            father.put(f, parent);
            f = temp;
        }
        return parent;
    }

    public void union(int x, int y){
        int root_x = find(x);
        int root_y = find(y);
        if(root_x != root_y){
            father.put(root_y, root_x);
        }
    }
}

public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        for(DirectedGraphNode node : nodes){
            set.add(node.label);
            for(DirectedGraphNode neighbor : node.neighbors){
                set.add(neighbor.label);
            }
        }
        
        UnionFind uf = new UnionFind(set);
        for(DirectedGraphNode node : nodes){
            int node1 = node.label;
            for(DirectedGraphNode neighbor : node.neighbors){
                int node2 = neighbor.label;
                int root1 = uf.find(node1);
                int root2 = uf.find(node2);
                if(root1 != root2){
                    uf.union(root1, root2);
                }
            }
        }
        
        return print(set, uf);
    }
    
    private List<List<Integer>> print(Set<Integer> set, UnionFind uf){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i : set){
            int father = uf.find(i);
            if(!map.containsKey(father)){
                map.put(father, new ArrayList<Integer>());
            }
            List<Integer> cc = map.get(father);
            cc.add(i);
            map.put(father, cc);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> list : map.values()){
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }
}
public class ConnectingGraph { 
    private int[] father;
    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_a] = root_b;
        }
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if(root_a == root_b){
            return true;
        }
        return false;
    }
    
    private int find(int a){
        if(father[a] == a){
            return a;
        }
        return father[a] = find(father[a]);
    }
}
public class ConnectingGraph3 {
    private int[] father;
    private int count;
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        count = n;
        for(int i = 0; i < n + 1; i++){
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_a] = root_b;
            count--;
        }
    }
        
    public int query() {
        // Write your code here
        return count;
    }
    
    private int find(int x){
        if(father[x] == x){
            return x;
        }
        return father[x] = find(father[x]);
    }
}
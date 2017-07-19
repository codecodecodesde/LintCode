/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class UnionFind{
    private int[] father;
    public UnionFind(int n){
        father = new int[n];
        for(int i = 0; i < n; i++){
            father[i] = i;
        }
    }
    
    public int find(int x){
        if(father[x] == x){
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    public void union(int x, int y){
        int root_x = find(x);
        int root_y = find(y);
        if(root_x != root_y){
            father[root_x] = root_y;
        }
    }
    
    public boolean isConnected(int x, int y){
        int root_x = find(x);
        int root_y = find(y);
        if(root_x == root_y){
            return true;
        }
        return false;
    }
}
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if(operators == null || operators.length == 0){
            return result;
        }
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        boolean[][] matrix = new boolean[n][m];
        int count = 0;
        UnionFind uf = new UnionFind(n * m);
        for(int i = 0; i < operators.length; i++){
            int x = operators[i].x;
            int y = operators[i].y;
            if(matrix[x][y]){
                result.add(count);
                continue;
            }
            matrix[x][y] = true;
            count++;
            int id = x * m + y;
            for(int j = 0; j < 4; j++){
                int nextX = x + dx[j];
                int nextY = y + dy[j];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                    continue;
                }
                if(!matrix[nextX][nextY]){
                    continue;
                }
                int id_next = nextX * m + nextY;
                if(!uf.isConnected(id, id_next)){
                    uf.union(id, id_next);
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }
}
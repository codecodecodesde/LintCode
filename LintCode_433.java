class Coordinate{
    public int x;
    public int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0|| grid[0].length == 0){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int numOfIslands = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j]){
                    bfs(grid, new Coordinate(i, j));
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    
    private void bfs(boolean[][] grid, Coordinate cor){
        int[] directionX = {0, -1, 0, 1};
        int[] directionY = {-1, 0, 1, 0};
        
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(cor);
        grid[cor.x][cor.y] = false;
        
        while(!queue.isEmpty()){
            Coordinate first = queue.poll();
            for(int i = 0; i < 4; i++){
                Coordinate neighbor = new Coordinate(first.x + directionX[i], first.y + directionY[i]);
                if(inBound(neighbor, grid)){
                    if(grid[neighbor.x][neighbor.y]){
                        queue.offer(neighbor);
                        grid[neighbor.x][neighbor.y] = false;
                    }
                }
            }
        }
    }
    
    private boolean inBound(Coordinate cor, boolean[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        if(cor.x >= 0 && cor.x < row && cor.y >= 0 && cor.y < col){
            return true;
        }
        return false;
    }
}
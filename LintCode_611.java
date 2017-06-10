/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class LintCode_611 {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int[] directionX = {1, 1, -1, -1, 2, 2, -2, -2};
    public int[] directionY = {2, -2, 2, -2, 1, -1, 1, -1};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        grid[source.x][source.y] = true;
        
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point next = queue.poll();
                for(int j = 0; j < 8; j++){
                    Point neighbor = new Point(next.x + directionX[j], next.y + directionY[j]);
                    if(!Go(grid, neighbor)){
                        continue;
                    }
                    if(neighbor.x == destination.x && neighbor.y == destination.y){
                        return count;
                    }
                    queue.offer(neighbor);
                    grid[neighbor.x][neighbor.y] = true;
                }
            }
        }
        
        return -1;
    }
    
    private boolean Go(boolean[][] grid, Point neighbor){
        int row = grid.length;
        int col = grid[0].length;
        if(neighbor.x < 0 || neighbor.x >= row || neighbor.y  < 0 || neighbor.y >= col){
            return false;
        }
        
        return grid[neighbor.x][neighbor.y] == false;
    }
}
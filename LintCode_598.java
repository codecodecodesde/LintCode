class Coordinate{
    public int x;
    public int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class LintCode_598 {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;
    public int zombie(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        // Write your code here
        int row = grid.length;
        int col = grid[0].length;
        int people = 0;
        int count = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == PEOPLE){
                    people++;
                }
                else if(grid[i][j] == ZOMBIE){
                    queue.offer(new Coordinate(i, j));
                }
            }
        }
        
        if(people == 0){
            return 0;
        }
        
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;//by layers
            for(int j = 0; j < size; j++){
                Coordinate first = queue.poll();
                for(int i = 0; i < 4; i++){
                   Coordinate neighbor = new Coordinate(first.x + directionX[i], first.y + directionY[i]);
                   if(!inBound(grid, neighbor)){
                       continue;
                   }
                   if(grid[neighbor.x][neighbor.y] == PEOPLE){
                       grid[neighbor.x][neighbor.y] = ZOMBIE;
                       people--;
                       if(people == 0){
                           return count;
                       }
                       queue.offer(neighbor);
                   }
                }
            }
        }

        return -1;
    }
    
    private boolean inBound(int[][] grid, Coordinate coor){
        int row = grid.length;
        int col = grid[0].length;
        
        return (coor.x >= 0 && coor.x < row && coor.y >=0 && coor.y < col);
    }
}
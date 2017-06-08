class Coordinate{
    public int x;
    public int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class LintCode_573 {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int EMPTY = 0;
    public int HOUSE = 1;
    public int WALL = 2;
    public int[] directionX = {0, 1, 0, -1};
    public int[] directionY = {1, 0, -1, 0};
    public int[][] grid;
    public int n, m;
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        setGrid(grid);
        
        ArrayList<Coordinate> houses = getCoordinate(HOUSE);
        ArrayList<Coordinate> empties = getCoordinate(EMPTY);
        int[][] visitedTime = new int[n][m];
        int[][] sum = new int[n][m];
        
        for(Coordinate house : houses){
            bfs(house, visitedTime, sum);
        }
        
        int minSum = Integer.MAX_VALUE;
        for(Coordinate empty : empties){
            if(visitedTime[empty.x][empty.y] != houses.size()){
                continue;
            }
            minSum = Math.min(minSum, sum[empty.x][empty.y]);
        }
        if(minSum == Integer.MAX_VALUE){
            return -1;
        }
        return minSum;
        
    }
    
    private ArrayList<Coordinate> getCoordinate(int target){
        ArrayList<Coordinate> houses = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == target){
                    houses.add(new Coordinate(i, j));
                }
            }
        }
        return houses;
    }
    
    private void bfs(Coordinate house, int[][] visitedTime, int[][] sum){
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] set = new boolean[n][m];
        queue.offer(house);
        set[house.x][house.y] = true;
        
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Coordinate first = queue.poll();
                for(int j = 0; j < 4; j++){
                    Coordinate neighbor = new Coordinate(first.x + directionX[j], first.y + directionY[j]);
                    if(!inBound(neighbor)){
                        continue;
                    }
                    if(set[neighbor.x][neighbor.y]){
                        continue;
                    }
                    queue.offer(neighbor);
                    set[neighbor.x][neighbor.y] = true;
                    visitedTime[neighbor.x][neighbor.y]++;
                    sum[neighbor.x][neighbor.y] += level;
                }
            }
        }
    }
    
    private boolean inBound(Coordinate coor){

        if(coor.x < 0 || coor.x >= n || coor.y < 0 || coor.y >= m){
            return false;
        }
        return grid[coor.x][coor.y] == EMPTY;
    }
    
    private void setGrid(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
    }
}
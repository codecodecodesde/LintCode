class Cell{
    int x, y, h;
    public Cell(int x, int y, int h){
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

class CellComparator implements Comparator<Cell>{
    public int compare(Cell c1, Cell c2){
        return c1.h - c2.h;
    }
}
public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        if(heights.length == 0){
            return 0;
        }
        
        int row = heights.length;
        int col = heights[0].length;
        int[][] visited = new int[row][col];
        PriorityQueue<Cell> pq = new PriorityQueue<>(1, new CellComparator());  
        for(int i = 0; i < col; i++){
            pq.offer(new Cell(0, i, heights[0][i]));
            pq.offer(new Cell(row - 1, i, heights[row - 1][i]));
            visited[0][i] = 1;
            visited[row - 1][i] = 1;
        }
        
        for(int i = 1; i < row - 1; i++){
            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, col - 1, heights[i][col - 1]));
            visited[i][0] = 1;
            visited[i][col - 1] = 1;
        }
        
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int water = 0;
        while(!pq.isEmpty()){
            Cell min = pq.poll();
            for(int i = 0; i < 4; i++){
                int next_x = min.x + dx[i];
                int next_y = min.y + dy[i];
                if(next_x < 0 || next_x >= row || next_y < 0 || next_y >= col || visited[next_x][next_y] == 1){
                    continue;
                }
                pq.offer(new Cell(next_x, next_y, Math.max(heights[next_x][next_y], min.h)));
                visited[next_x][next_y] = 1;
                water += Math.max(min.h - heights[next_x][next_y], 0);
            }
        }
        return water;
    }
}
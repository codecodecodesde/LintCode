class Point{
    public int x, y, val;
    public Point(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class comparator implements Comparator<Point>{
    public int compare(Point A, Point B){
        return A.val - B.val;
    }
}

public class LintCode_401 {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int[] directionX = new int[]{0, 1};
    public int[] directionY = new int[]{1, 0};
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        if(k <= 0){
            return -1;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>(k, new comparator());
        boolean[][] set = new boolean[row][col];
        pq.offer(new Point(0, 0, matrix[0][0]));
        set[0][0] = true;
        
        int i = 0;
        while(i < k - 1){
            Point min = pq.poll();
            for(int j = 0; j < 2; j++){
                int neighborX = min.x + directionX[j];
                int neighborY = min.y + directionY[j];
                if(neighborX >= row || neighborY >= col || set[neighborX][neighborY]) continue;
                Point neighbor = new Point(neighborX, neighborY, matrix[neighborX][neighborY]);
                pq.offer(neighbor);
                set[neighborX][neighborY] = true;
            }
            i++;
        }
        return pq.poll().val;
    }
}
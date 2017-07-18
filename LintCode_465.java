class Pair{
    public int x, y, val;
    public Pair(int x, int y, int val){
        this.x = x; 
        this.y = y;
        this.val = val;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair A, Pair B){
        return A.val - B.val;
    }
}
public class LintCode_465 {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if(k <= 0){
            return -1;
        }
        if( A.length == 0 && B.length != 0){
            return B[k - 1];
        }
        if(B.length == 0 && A.length != 0){
            return A[k - 1];
        }
        
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new PairComparator());
        boolean[][] set = new boolean[A.length][B.length];
        pq.offer(new Pair(0, 0, A[0] + B[0]));
        set[0][0] = true;
        
        for(int i = 0; i < k - 1; i++){
            Pair min = pq.poll();
            for(int j = 0 ; j < 2; j++){
                int nextX = min.x + dx[j];
                int nextY = min.y + dy[j];
                if(nextX >= A.length || nextY >= B.length ||set[nextX][nextY]){
                    continue;
                }
                Pair next = new Pair(nextX, nextY, A[nextX] + B[nextY]);
                pq.offer(next);
                set[nextX][nextY] = true;
            }
        }
        return pq.poll().val;
    }
}
class Pair{
    public int x, y;
    public int val;
    public Pair(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair A, Pair B){
        return B.val - A.val;
    }
}

public class LintCode_543 {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        int N = arrays.length;
       
        PriorityQueue<Pair> pq = new PriorityQueue<>(N, new PairComparator());
        for(int[] array : arrays){
            Arrays.sort(array);
        }
        
        for(int i = 0; i < N; i++){
            int length = arrays[i].length;
            if(length == 0) continue;
            pq.offer(new Pair(i, length - 1, arrays[i][length - 1]));
        }
        
        for(int t = 0; t < k - 1; t++){
            Pair max = pq.poll();
            int nextX = max.x;
            int nextY = max.y - 1;
            if(nextY < 0) continue;
            pq.offer(new Pair(nextX, nextY, arrays[nextX][nextY]));
        }
        
        return pq.poll().val;
    }
}
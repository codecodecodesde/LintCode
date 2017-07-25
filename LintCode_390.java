class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        int row = A.length;
        int col = A[0].length;
        
        return find(A, 0, row - 1, 0, col - 1, true);
    }
    
    private List<Integer> find(int[][] A, int x1, int x2, int y1, int y2, boolean flag){
        if(flag){
            int mid = x1 + (x2 - x1)/2;
            int idx = y1;
            for(int i = y1; i <= y2; i++){
                if(A[mid][i] > A[mid][idx]){
                    idx = i;
                }
            }
            
            if(A[mid - 1][idx] > A[mid][idx]){
                return find(A, x1, mid, y1, y2, !flag);
            }else if(A[mid + 1][idx] > A[mid][idx]){
                return find(A, mid, x2, y1, y2, !flag);
            }else{
                return new ArrayList<Integer>(Arrays.asList(mid, idx));
            }
        }else{
            int mid = y1 + (y2 - y1) / 2;
            int idx = x1;
            for(int i = x1; i <= x2; i++){
                if(A[i][mid] > A[idx][mid]){
                    idx = i;
                }
            }
            
            if(A[idx][mid - 1] > A[idx][mid]){
                return find(A, x1, x2, y1, mid, !flag);
            }else if(A[idx][mid + 1] > A[idx][mid]){
                return find(A, x1, x2, mid, y2, !flag);
            }else{
                return new ArrayList<Integer>(Arrays.asList(idx, mid));
            }
        }
    }
}
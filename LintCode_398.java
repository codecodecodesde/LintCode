public class Solution {
    /*
     * @param : An integer matrix
     * @return: an integer
     */
    private int row, col;
    private int[][] dp;
    private int[][] flag;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // write your code here
        if(A.length == 0 || A[0].length == 0){
            return 0;
        }
        
        row = A.length;
        col = A[0].length;
        flag = new int[row][col];
        dp = new int[row][col];
        
        int max = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dp[i][j] = search(i, j, A);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    
    private int search(int x, int y, int[][] A){
        if(flag[x][y] == 1){
            return dp[x][y];
        }
        
       int[] dx = new int[]{0, 1, 0, -1};
       int[] dy = new int[]{1, 0, -1, 0};
       int ans = 1;
       for(int i = 0; i < 4; i++){
           int nx = x + dx[i];
           int ny = y + dy[i];
           if(nx >= 0 && nx < row && ny >= 0 && ny < col){
               if(A[nx][ny] < A[x][y]){
                   ans = Math.max(ans, search( nx, ny, A) + 1);
                }
           }
       }
       flag[x][y] = 1;
       dp[x][y] = ans;
       return ans;
    }
}
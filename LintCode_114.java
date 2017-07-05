public class LintCode_114 {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        if(m == 0 || n == 0){
            return 0;
        }
        
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for(int i = 1; i < n; i++){
            f[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            f[i][0] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        
        return f[m - 1][n - 1];
    }
}
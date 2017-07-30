public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] f = new int[row][col];

        int maxSquare = matrix[0][0];
        for(int i = 0; i < row; i++){
            f[i][0] = matrix[i][0];
            maxSquare = Math.max(maxSquare, f[i][0]);
        }
        
        for(int i = 0; i < col; i++){
            f[0][i] = matrix[0][i];
            maxSquare = Math.max(maxSquare, f[0][i]);
        }
        
        for(int i = 1; i  < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 1){
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i][j - 1], f[i - 1][j])) + 1;
                }
                maxSquare = Math.max(maxSquare, f[i][j] * f[i][j]);
            }
        }
        return maxSquare;
    }
}


public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] f = new int[2][col];

        int maxSquare = matrix[0][0];
        for(int i = 0; i  < row; i++){
            f[i%2][0] = matrix[i][0];
            maxSquare = Math.max(maxSquare, f[i%2][0]);
            for(int j = 1; j < col; j++){
                if(i > 0){
                    if(matrix[i][j] == 1){
                        f[i%2][j] = Math.min(f[(i - 1)%2][j - 1], Math.min(f[i%2][j - 1], f[(i - 1)%2][j])) + 1;
                    }else{
                        f[i%2][j] = 0;//一定要写！ 这里是不断更新的，不重写会错
                    }
                }else{
                    f[0][j] = matrix[0][j];
                }
                maxSquare = Math.max(maxSquare, f[i%2][j]);
            }
        }
        
        return maxSquare * maxSquare;
    }
}
public class LintCode_38 {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1; 
        int y = 0;
        int count = 0;
        
        while(x >= 0 && y <= col - 1){
            if(matrix[x][y] < target){
                y++;
            }
            else if(matrix[x][y] > target){
                x--;
            }
            else{
                x--;
                y++;
                count++;
            }
        }
        
        return count;
    }
}
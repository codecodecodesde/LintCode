public class LintCode_28 {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        
        // write your code here
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = 0;
        int end = row - 1;
        int mid;
        int targetRow;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(matrix[mid][0] == target){
                return true;
            }
            if(matrix[mid][0] > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(matrix[end][0] <= target){
            targetRow = end;
        }
        else if(matrix[start][0] <= target){
            targetRow = start;
        }
        else{
            return false;
        }
        return findTarget(matrix[targetRow], target);
    }
    
    public boolean findTarget(int[] m, int target){
        if(m == null || m.length == 0){
            return false;
        }
        
        int start = 0;
        int end = m.length - 1;
        int mid;
        
        while(start + 1  < end){
            mid = start + (end - start) / 2;
            if(m[mid] == target){
                return true;
            }
            else if(m[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(m[start] == target){
            return true;
        }
        if(m[end] == target){
            return true;
        }
        return false;
    }
}

//use once binary search
public class LintCode_28_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = row * col - 1;
        int mid;

        while(start + 1  < end){
            mid = start + (end - start) / 2;
            int number = matrix[mid / col][mid % col];
            if(number == target){
                return true;
            }
            if(number < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(matrix[start / col][start % col] == target){
            return true;
        }
        if(matrix[end / col][end % col] == target){
            return true;
        }
        return false;
    }

}
















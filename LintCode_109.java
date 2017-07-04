public class LintCode_109 {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */

    //Divide&Conquer can't pass the test O(2^n)
    public int minimumTotal(int[][] triangle) {
        // write your code here
        
        int min = helper(triangle, 0, 0);
        return min;
    }
    
    private int helper(int[][] triangle, int x, int y){
        if(x == triangle.length){
            return 0;
        }
        
        int left = helper(triangle, x + 1, y);
        int right = helper(triangle, x + 1, y + 1);
        return triangle[x][y] + Math.min(left, right);
    }
}


//Divide & Conquer + Memorization
public class LintCode_109_2 {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    private int[][] counted;
    public int minimumTotal(int[][] triangle) {
        // write your code here
        counted = new int[triangle.length][triangle.length];
        for(int i = 0; i < triangle.length; i++){
            for(int j = 0; j < triangle.length; j++){
                counted[i][j] = Integer.MAX_VALUE;
            }
        }
       
        int min = helper(triangle, 0, 0);
        return min;
    }
    
    private int helper(int[][] triangle, int x, int y){
        if(x == triangle.length){
            return 0;
        }
        
        if(counted[x][y] != Integer.MAX_VALUE){
            return counted[x][y];
        }
        
        int left = helper(triangle, x + 1, y);
        int right = helper(triangle, x + 1, y + 1);
        counted[x][y] = triangle[x][y] + Math.min(left, right);
        return counted[x][y];
    }
}

public class LintCode_109_3 {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        for(int i = 0; i < n; i++){
            f[n - 1][i] = triangle[n - 1][i];
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                f[i][j] = triangle[i][j] + Math.min(f[i + 1][j], f[i + 1][j + 1]);
            }
        }
        
        return f[0][0];
    
    }
}

public class LintCode_109_4 {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        f[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++){
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < i; j++){
                f[i][j] = triangle[i][j] + Math.min(f[i - 1][j - 1], f[i - 1][j]);
            }
        }
        
        int min = f[n - 1][0];
        for(int i = 1; i < n; i++){
            min = Math.min(f[n - 1][i], min);
        }
        return min;
    }
}
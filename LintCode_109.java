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
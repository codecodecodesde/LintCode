public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int max = 0;
        for(int i = row - 1; i >= 0; i--){
            for(int j = 0; j < col; j++){
                height[j] = matrix[i][j]? height[j] + 1 : 0;
            }
            max = Math.max(max, findLargest(height));
        }
        return max;
    }
    
    private int findLargest(int[] height){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            int curH = (i == height.length) ? -1 : height[i];
            while(!stack.empty() && curH <= height[stack.peek()]){
                int h = height[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
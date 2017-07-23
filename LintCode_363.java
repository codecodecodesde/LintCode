public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights.length == 0){
            return 0;
        }
        int i = 0, j = heights.length - 1;
        int leftheight = heights[i];
        int rightheight = heights[j];
        int water = 0;
        while(i < j){
            if(heights[i] <= heights[j]){
                i++;
                if(leftheight < heights[i]){
                    leftheight = heights[i];
                }else{
                    water += leftheight - heights[i];
                }
            }else{
                j--;
                if(rightheight < heights[j]){
                    rightheight = heights[j];
                }else{
                    water += rightheight - heights[j];
                }
            }
        }
        return water;
    }
}
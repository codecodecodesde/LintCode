public class Solution {
    /*
     * @param : An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A.length == 0){
            return 0;
        }
        
        int[] f = new int[A.length];
        f[0] = 1;
        int max = 1;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i - 1]){
                f[i] = f[i - 1] + 1;
            }else{
                f[i] = 1;
            }
            max = Math.max(max, f[i]);
        }
        f[A.length - 1] = 1;
        for(int i = A.length - 2; i >= 0; i--){
            if(A[i] > A[i + 1]){
                f[i] = f[i + 1] + 1;
            }else{
                f[i] = 1;
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
public class LintCode_116 {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0){
            return false;
        }
        
        int farthest = A[0];
        for(int i = 1; i < A.length; i++){
            if(i <= farthest && i + A[i] >= farthest){
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }
}
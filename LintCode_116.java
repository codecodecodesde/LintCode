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

public class LintCode_116_2 {
    public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[A.length - 1];
    }
}
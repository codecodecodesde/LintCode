public class LintCode_272 {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        if(n == 0|| n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        for(int i = 3; i < n; i++){
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }
        return f[n - 1];
    }
}
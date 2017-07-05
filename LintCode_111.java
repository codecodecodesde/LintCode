public class LintCode_111 {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n == 0 || n == 1){
            return 1;
        }

        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for(int i = 2; i < n ; i++){
            f[i] = f[i -1] + f[i - 2];
        }
        return f[n - 1];
    }
}
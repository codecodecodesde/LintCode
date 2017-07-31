public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if(n == 0){
            return false;
        }
        
        int[] dp = new int[n + 1];
        return MemorizedSearch(dp, n);
    }
    
    private boolean MemorizedSearch(int[] dp, int n){
        if(dp[n] != 0) {
            if(dp[n] == 1)
                return false;
            else
                return true;
        }

        if(n <= 0){
            dp[0] = 1;
        }else if(n == 1){
            dp[1] = 2;
        }else if(n == 2){
            dp[2] = 2;
        }else if(n == 3){
            dp[3] = 1;
        }else{
            if((MemorizedSearch(dp, n - 2) && MemorizedSearch(dp, n - 3)) || (MemorizedSearch(dp, n - 3) && MemorizedSearch(dp, n - 4))){
                dp[n] = 2;
            }else{
                dp[n] = 1;
            }
        }
        if(dp[n] == 2) 
            return true;
        return false;
    }
}
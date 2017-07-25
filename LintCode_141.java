class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x == 0){
            return 0;
        }
        
        long start = 1, end = x;
        while(start + 1 < end){
            long mid = start + (end - start) / 2;
            if(mid * mid < x){
                start = mid;
            }else if(mid * mid > x){
                end = mid;
            }else{
                return (int) mid;
            }
        }
        
        if(end * end <= x){
            return (int) end;
        }
        return (int) start;
    }
}
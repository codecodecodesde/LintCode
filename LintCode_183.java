public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < L.length; i++){
            max = Math.max(max, L[i]);
        }
        
        int start = 1, end = max;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(numOfCut(mid, L) < k){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        if(numOfCut(end, L) >= k){
            return end;
        }
        if(numOfCut(start, L) >= k){
            return start;
        }
        return 0;
    }
    
    private int numOfCut(int mid, int[] L){
        int cut = 0;
        for(int i = 0; i < L.length; i++){
            cut += L[i]/mid;
        }
        return cut;
    }
}
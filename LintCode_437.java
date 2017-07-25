public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages.length == 0){
            return 0;
        }
        
        int start = 0;
        int end = 0;
        for(int i = 0; i < pages.length; i++){
            start = Math.max(start, pages[i]);
            end += pages[i];
        }

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(numOfperson(mid, pages) > k){
                start = mid;
            }else{
                end = mid;
            }
            
        }
        
        if(numOfperson(start, pages) <= k){
            return start;
        }
        return end;
    }
    
    private int numOfperson(int mid, int[] pages){
        int count = 1;
        int sum = pages[0];
        for(int i = 1; i < pages.length; i++){
            if(sum + pages[i] > mid){
                count++;
                sum = 0;
            }
            sum += pages[i];
        }
        return count;
    }
}
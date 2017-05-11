public class LintCode_462 {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0){
            return 0;
        }
        if (A[0] > target || A[A.length - 1] < target ){
            return 0;
        }
        
        int start = 0;
        int end = A.length - 1;
        while(start + 1  < end){
            int mid = start + (end - start) / 2;
            if (A[mid]  < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        int firstPos = -1;
        if(A[start] == target){
            firstPos = start;
        }
        else if(A[end] == target){
            firstPos = end;
        }
        else{
            return 0;
        }
        
        int lastPos = -1;
        start = 0; 
        end = A.length - 1;
        while (start + 1  < end){
            int mid = start + (end - start) / 2;
            if (A[mid] > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if (A[end] == target){
            lastPos = end;
        }
        else{
            lastPos = start;
        }
        
        return lastPos - firstPos + 1;
    }
}
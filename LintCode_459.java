public class LintCode_459 {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        int mid;
        
        while (start + 1 < end){
            mid = start + (end -start) / 2;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        if(A[start] == target){
            return start;
        }
        if(A[end] == target){
            return end;
        }
        if((target - A[start]) - (A[end] - target) >= 0){
            return end;
        }
        else{
            return start;
        }
    }
}
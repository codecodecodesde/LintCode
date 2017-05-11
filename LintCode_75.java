class LintCode_75 {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                return mid;
            }
            if (A[mid] > A[mid + 1]){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        
        return A[start] > A[end] ? start : end;
    }
}
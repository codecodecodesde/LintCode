class LintCode_65 {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int size = A.length + B.length;
        if(size % 2 == 0){
            return (findKth(A, 0, B, 0, size/2) + findKth(A, 0, B, 0, size/2 + 1))/2.0;
        }
        else{
            return findKth(A, 0, B, 0, size/2 + 1);
        }
    }
    
    private int findKth(int[] A, int A_start, int[] B, int B_start, int k){
        if(A_start >= A.length){
            return B[B_start + k - 1];
        }
        
        if(B_start >= B.length){
            return A[A_start + k - 1];
        }
        
        if(k == 1){
            return Math.min(A[A_start], B[B_start]);
        }
        
        int A_value = A_start + k/2 - 1 < A.length ?
                      A[A_start + k/2 - 1] : Integer.MAX_VALUE;
        int B_value = B_start + k/2 - 1 < B.length ?
                      B[B_start + k/2 - 1] : Integer.MAX_VALUE;
                      
        if(A_value > B_value){
            return findKth(A, A_start, B, B_start + k/2, k - k/2);
        }
        else{
            return findKth(A, A_start + k/2, B, B_start, k - k/2);
        }

    }
}
public class LintCode_130 {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        for(int i = (A.length - 1)/2; i >= 0; i--){
            sink(A, i);
        }
    }
    
    private void sink(int[] A, int k){
        while(k < A.length){
            int smallest = k;
            if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
                smallest = k * 2 + 1;
            }
            if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
                smallest = k * 2 + 2;
            }
            if(A[k] > A[smallest]){
                exch(A, k, smallest);
                k = smallest;
            }
            else{
                break;
            }
        }
    }

    private void exch(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
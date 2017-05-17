public class LintCode_62 {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        
        int minIndex = findMin(A);
        int start, end, mid;
        if(target <= A[A.length - 1]){
            start = minIndex;
            end = A.length - 1;
        }
        else{
            start = 0;
            end = minIndex - 1;
        }
        
        while(start + 1 < end){
            mid = start + (end - start) / 2;
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
        return -1;
    }
    
    public int findMin(int[] A) {
        int start = 0, end = A.length - 1;
        while(start + 1  < end){
            int mid = start + (end - start) / 2;
            if(A[mid] <= A[end]){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(A[start] < A[end]){
            return start;
        }
        return end;
    }

}
//follow up question: use onece binary search
public class LintCode_62_2 {
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid] >= A[start]){
                if(target < A[mid] && target >= A[start]){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            else{
                if(target > A[mid] && target <= A[A.length - 1]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        if(A[start] == target){
            return start;
        }
        if(A[end] == target){
            return end;
        }
        return -1;
}
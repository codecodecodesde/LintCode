public class LintCode_211 {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        if(A == null || B == null){
            return false;
        }
        if(A.length() != B.length()){
            return false;
        }
        
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
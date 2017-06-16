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

public class LintCode_211_2 {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        Map<Character, Integer> hashmap =new HashMap<>();
        for(int i = 0; i < A.length(); i++){
            if(hashmap.containsKey(A.charAt(i))){
                hashmap.put(A.charAt(i), hashmap.get(A.charAt(i)) + 1);
            }
            else{
                hashmap.put(A.charAt(i), 1);
            }
        }
        
        for(int i  = 0; i < B.length(); i++){
            if(hashmap.containsKey(B.charAt(i))){
                hashmap.put(B.charAt(i), hashmap.get(B.charAt(i)) - 1);
            }
            else{
                return false;
            }
        }
        
        for(Object value : hashmap.values()){
            if((int)value != 0){
                return false;
            }
        }
        return true;
    }
}
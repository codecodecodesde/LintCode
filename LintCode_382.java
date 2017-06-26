public class LintCode_382 {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if(S == null || S.length < 3){
            return 0;
        }
        
        Arrays.sort(S);
        int count = 0;
        for(int i = 2; i < S.length; i++){
            int start = 0;
            int end = i - 1;
            while(start < end){
                if(S[start] + S[end] > S[i]){
                    count += end - start;
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return count;
    }
}